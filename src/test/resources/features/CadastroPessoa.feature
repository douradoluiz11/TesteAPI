
@tag
Feature: Cadastro de Pessoas API

  @tag1
  Scenario: Cadastrar Nova Pessoa
  Given Pessoa informa Dados Cadastrais Obrigatorios
  And Valido Status 201
  
  @tag2
  Scenario: Cadastrar Pessoa com CPF Ja Cadastrado
  Given Pessoa informa CPF ja cadastrado anteriormente
  And Valido Mensagem Post "Já existe pessoa cadastrada com o CPF" e codigo 400
  
  @tag3
  Scenario: Cadastrar Pessoa com Telefone Ja Cadastrado
  Given Pessoa informa Telefone ja cadastrado anteriormente
  And Valido Mensagem Post "Já existe pessoa cadastrada com o Telefone" e codigo 400
  
  @tag4
  Scenario: Pesquisa pessoa por DDD e Telefone cadastrado
    Given Pessoa Pesquisa por Telefone e DDD
    And Valido Status Get 200

	@tag5
  Scenario: Pesquisa pessoa por DDD e Telefone não cadastrado
    Given Pessoa Pesquisa por Telefone e DDD
    And Valido Mensagem Get "Não existe pessoa com o telefone" e codigo 404
