package com.api.mutanthuman.infrastructure.entrypoints.controller.stat;

import com.api.mutanthuman.domain.usecase.stat.StatUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stats")
@Tag(name = "Estadisticas")
public class StatController {

    @Autowired
    private StatUseCase statUseCase;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    @Operation(summary = "Consultar Estadisticas", description = "Retorna la estadistica de los ADNs analizados", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")}
    )
    public ResponseEntity getStatsDna() {
        return new ResponseEntity(mapper.map(statUseCase.getStatsDna(), StatDnaAnalizedDTO.class), HttpStatus.OK);
    }

}
