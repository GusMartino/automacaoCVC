#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @BookingCreate @Cenário01 @BookingIssue @CancellBNPL @Ida
Funcionalidade: Validação de post em criação de reserva
    Eu como usuário quero criar minha reserva aérea

@CT01 
Cenário: Post de criação de reserva com um adulto em voo SAO/RIO 
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "1" junto ao token "bTokenCT01"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken01"
    E válido localizador "reservationCode01"
    E válido preço total de reserva "totalOrderPrice01"
    
@CT02 
Cenário: Post de criação de reserva com um adulto e uma criança em voo SAO/MAD
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "2" junto ao token "bTokenCT02"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken02"
    E válido localizador "reservationCode02"
    E válido preço total de reserva "totalOrderPrice02"

@CT03 
Cenário: Post de criação de reserva com um adulto e um bebê em voo GIG/BPS
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "3" junto ao token "bTokenCT03"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken03"
    E válido localizador "reservationCode03"
    E válido preço total de reserva "totalOrderPrice03"
    
    @CT04 @Test
Cenário: Post de criação de reserva com nove adultos em voo MAD/SAO
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "4" junto ao token "bTokenCT04"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken04"
    E válido localizador "reservationCode04"
    E válido preço total de reserva "totalOrderPrice04"

    @CT05 @Test
Cenário: Post de criação de reserva com um adulto e oito crianças em voo BPS/FLN
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "5" junto ao token "bTokenCT05"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken05"
    E válido localizador "reservationCode05"
    E válido preço total de reserva "totalOrderPrice05"
    
    @CT06
Cenário: Post de criação de reserva com três adultos, três crianças e três bebês em voo FLN/GRU
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "6" junto ao token "bTokenCT06"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken06"
    E válido localizador "reservationCode06"
    E válido preço total de reserva "totalOrderPrice06"    
    
    @CT07 
Cenário: Post de criação de reserva com um adulto estrangeiro em voo DXB/GRU
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "7" junto ao token "bTokenCT07"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken07"
    E válido localizador "reservationCode07"
    E válido preço total de reserva "totalOrderPrice07"        
