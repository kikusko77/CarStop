package org.but.eloryksauthorization.newbackend.rest;

import org.but.eloryksauthorization.newbackend.service.BlobSasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private BlobSasService blobSasService;

    @GetMapping("/{name}/sas")
    public ResponseEntity<BlobSasService.SasResult> getSas(@PathVariable String name) {
        return ResponseEntity.ok(blobSasService.generateReadSas(name, 5));
    }
}
