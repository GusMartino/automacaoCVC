#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

 @FlightAvailabilit @Cenário03 
Funcionalidade: Validação de get em FlightAvailability resposta negativa
    Eu como usuário quero fazer pesquisa de passagens forçando erro para validar resposta de API

  @CT01
  Cenário: Get com dez adultos
    Dado que o usuário faça uma pesquisa de disponibilidade de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,30,30,30,30,30,30,30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,RIO,2023-10-10&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando preencho uma váriavel negativa para consultar disponibilidade
    Então válido statusCode 500
    E válido código de erro "05-001-000" e resposta "[Dados de entrada inconsistentes, 1673 - Number of passengers exceeded the limit]"
   
   @CT02
   Cenário: Get sem passageiro
    Dado que o usuário faça uma pesquisa de disponibilidade de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,RIO,2023-10-10&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando preencho uma váriavel negativa para consultar disponibilidade
    Então válido statusCode 500
    E válido código de erro "05-001-000" e resposta "[Dados de entrada inconsistentes, 1673 - Number of passengers exceeded the limit]"
    
   @CT03
   Cenário: Get sem areporto 
    Dado que o usuário faça uma pesquisa de disponibilidade de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=RIO,2023-10-10&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando preencho uma váriavel negativa para consultar disponibilidade
    Então válido statusCode 500
    
   @CT04
   Cenário: Get com aeroporto inválido (SAMP)
    Dado que o usuário faça uma pesquisa de disponibilidade de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAMP,RIO,2023-10-10&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando preencho uma váriavel negativa para consultar disponibilidade
    Então válido statusCode 500
 
   @CT05
   Cenário: Get com data em branco
    Dado que o usuário faça uma pesquisa de disponibilidade de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,RIO,&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando preencho uma váriavel negativa para consultar disponibilidade
    Então válido statusCode 500
   
   @CT06
   Cenário: Get com data anterior ao dia de hoje
    Dado que o usuário faça uma pesquisa de disponibilidade de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,RIO,2023-08-08&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando preencho uma váriavel negativa para consultar disponibilidade
    Então válido statusCode 500
   
   @CT07
   Cenário: Get com para voo sem disponibilidade 
    Dado que o usuário faça uma pesquisa de disponibilidade de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=DXB,CGH,2024-02-08&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando preencho uma váriavel negativa para consultar disponibilidade
    Então válido statusCode 200   
    E válido retorno de voos zerado
    