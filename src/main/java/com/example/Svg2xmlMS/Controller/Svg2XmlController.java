package com.example.Svg2xmlMS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.Svg2xmlMS.svg2xml.Svg2Xml;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class Svg2XmlController {
    private final Svg2Xml svg2Xml = new Svg2Xml();


    @PostMapping("/convert")
    public ResponseEntity<String> convertSvgToXml(@RequestParam("svgFile") MultipartFile svgFile) {
        if (svgFile.isEmpty()) {
            return ResponseEntity.badRequest().body("No SVG file provided.");
        }

        try {
            // Créer un fichier temporaire avec le contenu du fichier SVG
            File tempFile = File.createTempFile("temp", ".svg");
            svgFile.transferTo(tempFile);

            // Appeler la méthode convertToXml avec un tableau contenant le fichier temporaire
            String xmlString = svg2Xml.convertToXml(new File[] { tempFile });

            // Supprimer le fichier temporaire
            tempFile.delete();
    
            return ResponseEntity.ok(xmlString);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during conversion: " + e.getMessage());
        }
    }
}
