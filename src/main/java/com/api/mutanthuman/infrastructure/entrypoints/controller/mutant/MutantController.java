package com.api.mutanthuman.infrastructure.entrypoints.controller.mutant;

import com.api.mutanthuman.domain.usecase.mutant.MutantUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mutant")
@Tag(name = "Mutant")
public class MutantController {

    @Autowired
    private MutantUseCase mutantUseCase;

    @PostMapping
    @Operation(summary = "Es mutante", description = "Evalua si el ADN es de un mutante o no", responses = {
            @ApiResponse(responseCode = "200", description = "El ADN evaluado es de un mutante"),
            @ApiResponse(responseCode = "400", description = "La secuencia de ADN evaluada no está bien formada"),
            @ApiResponse(responseCode = "403", description = "El ADN evaluado no es de un mutante")})
    public ResponseEntity isMutant(@RequestBody RequestDNA requestDNA){
        boolean isMutant = mutantUseCase.isMutant(requestDNA.getDna());
        return isMutant ? new ResponseEntity(isMutant, HttpStatus.OK) : new ResponseEntity(isMutant, HttpStatus.FORBIDDEN);
    }
}
