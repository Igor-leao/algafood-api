package com.igor.ifood;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import java.io.InputStream;

import static org.hamcrest.Matchers.equalTo;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.igor.ifood.util.ResourceUtils;

import com.igor.ifood.domain.model.Cozinha;
import com.igor.ifood.domain.repository.CozinhaRepository;
import com.igor.ifood.util.DatabaseCleaner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaIT {

	@LocalServerPort
	private int port;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	private Long quantidadeDeCozinhas;
	
	private static final String nomeDeCozinhaTeste = "Americana";
	
	private static final Long cozinhaIdInexistente= 100L;
	
	private String jsonCorretoCozinhaChinesa;
	

	
	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.basePath = "/cozinhas";
		RestAssured.port = port;
		databaseCleaner.clearTables();
		prepararDados();
		quantidadeDeCozinhas = buscaDados();
		
		jsonCorretoCozinhaChinesa = ResourceUtils.getContentFromResource(
				"/CozinhaDados.json");
		
	}
	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {
		
		given()
			.accept(ContentType.JSON)
		.when().get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarQuantidadeCorretaDeCozinhas_QuandoConsultarCozinhas() {
		
		given()
			.accept(ContentType.JSON)
		.when().get()
		.then()
		.body("", hasSize(2))
			.body("nome", hasItems("Americana", "Tailandesa"));
	}
	
	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaExistente() {
		given()
			.pathParam("cozinhaId", quantidadeDeCozinhas)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("nome", equalTo(nomeDeCozinhaTeste));
	}
	
	@Test
	public void deveRetornarStatus404_QuandoConsultarCozinhaInexistente() {
		given()
			.pathParam("cozinhaId", cozinhaIdInexistente)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {
		given()
			.body(jsonCorretoCozinhaChinesa)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	private void prepararDados() {
		Cozinha cozinha1 = new Cozinha();
		Cozinha cozinha2 = new Cozinha();
		
		cozinha1.setNome("Tailandesa");
		cozinha2.setNome("Americana");
		
		cozinhaRepository.save(cozinha1);
		cozinhaRepository.save(cozinha2);
	
	}
	
	private Long buscaDados() {
		Cozinha cozinha = new Cozinha();
		return cozinhaRepository.count();
	}


}
