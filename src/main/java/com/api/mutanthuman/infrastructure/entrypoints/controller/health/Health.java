package com.api.mutanthuman.infrastructure.entrypoints.controller.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
@Tag(name = "Salud de la API")
public class Health {

    @GetMapping
    @Operation(summary = "Salud de la API", description = "Retorna el estado de la API desplegada", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation")})
    public ResponseEntity getHealth() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
