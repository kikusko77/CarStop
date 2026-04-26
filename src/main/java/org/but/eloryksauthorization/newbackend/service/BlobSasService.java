package org.but.eloryksauthorization.newbackend.service;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.sas.BlobSasPermission;
import com.azure.storage.blob.sas.BlobServiceSasSignatureValues;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.azure.storage.common.sas.SasProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class BlobSasService {

    @Value("${storage.account.name:}")
    private String accountName;

    @Value("${storage.account.key:}")
    private String accountKey;

    @Value("${storage.protected.container:protected}")
    private String container;

    public SasResult generateReadSas(String blobName, int expiryMinutes) {
        if (accountName == null || accountName.isBlank()) {
            throw new IllegalStateException("storage.account.name is not configured");
        }
        OffsetDateTime expiry = OffsetDateTime.now().plusMinutes(expiryMinutes);
        BlobSasPermission permission = new BlobSasPermission().setReadPermission(true);
        BlobServiceSasSignatureValues values = new BlobServiceSasSignatureValues(expiry, permission)
                .setProtocol(SasProtocol.HTTPS_ONLY);

        String endpoint = "https://" + accountName + ".blob.core.windows.net";

        if (accountKey != null && !accountKey.isBlank()) {
            // Part 3.6: shared-key SAS
            StorageSharedKeyCredential cred = new StorageSharedKeyCredential(accountName, accountKey);
            BlobClient blob = new BlobClientBuilder()
                    .endpoint(endpoint)
                    .credential(cred)
                    .containerName(container)
                    .blobName(blobName)
                    .buildClient();
            String sas = blob.generateSas(values);
            return new SasResult(blob.getBlobUrl() + "?" + sas, expiry.toString());
        }

        // Bonus B.4: user-delegation SAS via managed identity
        BlobServiceClient svc = new BlobServiceClientBuilder()
                .endpoint(endpoint)
                .credential(new DefaultAzureCredentialBuilder()
                        .managedIdentityClientId(System.getenv("AZURE_CLIENT_ID"))
                        .build())
                .buildClient();

        var udk = svc.getUserDelegationKey(OffsetDateTime.now().minusMinutes(1), expiry);
        BlobClient blob = svc.getBlobContainerClient(container).getBlobClient(blobName);
        String sas = blob.generateUserDelegationSas(values, udk);
        return new SasResult(blob.getBlobUrl() + "?" + sas, expiry.toString());
    }

    public record SasResult(String url, String expires) {}
}
