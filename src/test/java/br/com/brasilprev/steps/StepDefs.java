package br.com.brasilprev.steps;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import org.springframework.util.Assert;

import br.com.brasilprev.actions.Actions;
import io.cucumber.java8.En;

public class StepDefs implements En {

	Actions action;

	public StepDefs() {

		action = new Actions();

		Given("Pessoa informa Dados Cadastrais Obrigatorios", () -> {

			action.PreenchePostBody();

		});

		Given("Pessoa informa CPF ja cadastrado anteriormente", () -> {

			action.PreenchePostBody();

		});

		Given("Pessoa informa Telefone ja cadastrado anteriormente", () -> {

			action.PreenchePostBody();

		});

		Given("Valido Status {int}", (Integer statusCode) -> {

			action.ValidaResponse(statusCode);

		});

		Given("Valido Mensagem Get {string} e codigo {int}", (String mensagem, Integer statusCode) -> {

			String result = action.ValidaResposeGet(statusCode);
			String resultTratada = result.substring(9, 46);
			Assert.hasText(mensagem, result);
			JOptionPane.showMessageDialog(null, resultTratada);

		});

		Given("Valido Mensagem Post {string} e codigo {int}", (String mensagem, Integer statusCode) -> {

			String result = action.ValidaResponse(statusCode);
			String resultTratada = result.substring(9, 46);
			Assert.hasText(mensagem, result);
			JOptionPane.showMessageDialog(null, resultTratada);

		});

		Given("Pessoa Pesquisa por Telefone e DDD", () -> {

			action.ExecutaGet();

		});

		Given("Valido Status Get {int}", (Integer statusCode) -> {

			action.ValidaResposeGet(statusCode);

		});

	}

}
