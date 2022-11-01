package com.maxima.avaliacao.controllers;

import com.maxima.avaliacao.models.Cliente;
import com.maxima.avaliacao.services.ClienteService;
import com.maxima.avaliacao.vo.ClienteCompletoVO;
import com.maxima.avaliacao.vo.ClienteRecebeVO;
import com.maxima.avaliacao.vo.ClienteVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Buscar clientes por filtro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping()
    public ResponseEntity<Page<ClienteCompletoVO>> search(
            @RequestParam(
                    value = "searchTerm",
                    required = false ) String searchTerm,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size
    ) {
        return ResponseEntity.ok().body(clienteService.search(searchTerm, page, size));
    }

    @Operation(summary = "Buscar cliente por codigo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                    content = @Content) })
    @GetMapping("/{codigo}")
    public ResponseEntity<ClienteVO> findById(@PathVariable Long codigo) {
        return ResponseEntity.ok().body(clienteService.findById(codigo));
    }

    @Operation(summary = "Cadastrar novo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "400", description = "Cliente já cadastrado",
                    content = @Content) })
    @PostMapping()
    public ResponseEntity<ClienteVO> save(@RequestBody ClienteRecebeVO vo) {
        return new ResponseEntity<>(clienteService.save(vo), HttpStatus.CREATED);
    }
}
