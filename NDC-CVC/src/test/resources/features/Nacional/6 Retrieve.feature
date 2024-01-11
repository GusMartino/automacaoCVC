#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @Retrieve 
Funcionalidade: Validação de get em Retrieve
    Eu como usuário quero fazer pesquisa de recuperação de passagens para validar status de minha passagem

  @CT01 @CancellBNPL
  Cenário: Get em bilhete do CT01 Ida
  Dado que tenho guardado o localizador "reservationCode01"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
  
  @CT02 @CancellBNPL
  Cenário: Get em bilhete do CT02 Ida
  Dado que tenho guardado o localizador "reservationCode02"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
 
  @CT03 @CancellBNPL
  Cenário: Get em bilhete do CT03 Ida
  Dado que tenho guardado o localizador "reservationCode03"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
 
  @CT04 @CancellBNPL
  Cenário: Get em bilhete do CT04 Ida
  Dado que tenho guardado o localizador "reservationCode04"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"

  @CT05 @CancellBNPL
  Cenário: Get em bilhete do CT05 Ida
  Dado que tenho guardado o localizador "reservationCode05"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
 
  @CT06 @CancellBNPL
  Cenário: Get em bilhete do CT06 Ida
  Dado que tenho guardado o localizador "reservationCode06"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"

  @CT07 @CancellBNPL
  Cenário: Get em bilhete do CT07 Ida
  Dado que tenho guardado o localizador "reservationCode07"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
  
  @CT01 @Cenário02 @CancellVoid 
  Cenário: Get em bilhete do CT01 ida e volta
  Dado que tenho guardado o localizador "reservationCodeVolta01"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
  
  @CT02 @Cenário02 @CancellVoid
  Cenário: Get em bilhete do CT02 ida e volta
  Dado que tenho guardado o localizador "reservationCodeVolta02"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
 
  @CT03 @Cenário02 @CancellVoid
  Cenário: Get em bilhete do CT03 ida e volta
  Dado que tenho guardado o localizador "reservationCodeVolta03"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
 
  @CT04 @Cenário02 @CancellVoid
  Cenário: Get em bilhete do CT04 ida e volta
  Dado que tenho guardado o localizador "reservationCodeVolta04"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"

  @CT05 @Cenário02 @CancellVoid
  Cenário: Get em bilhete do CT05 ida e volta
  Dado que tenho guardado o localizador "reservationCodeVolta05"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"
 
  @CT06 @Cenário02 @CancellVoid
  Cenário: Get em bilhete do CT06 ida e volta
  Dado que tenho guardado o localizador "reservationCodeVolta06"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"

  @CT07 @Cenário02 @CancellVoid
  Cenário: Get em bilhete do CT07 ida e volta
  Dado que tenho guardado o localizador "reservationCodeVolta07"
  Quando faço um get em url de retrieve "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/NLAT/"
  Então válido status code de reposta 200 junto ao status do bilhete "CANCELLED"  
     