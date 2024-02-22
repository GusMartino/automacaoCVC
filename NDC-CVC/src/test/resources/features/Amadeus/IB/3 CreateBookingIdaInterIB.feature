#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

 @BookingCreateInter @Cenário04 @BookingIssueInter
Funcionalidade: Validação de post em criação de reserva
    Eu como usuário quero criar minha reserva aérea

@CT08 
Cenário: Post de criação de reserva com um adulto em voo MAD/BCN 
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "1" junto ao token "bTokenCT01"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken01"
    E válido localizador "reservationCode01"
    E válido preço total de reserva "totalOrderPrice01"
    
@CT09 
Cenário: Post de criação de reserva com um adulto e uma criança em voo GRU/MAD
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "2" junto ao token "bTokenCT02"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken02"
    E válido localizador "reservationCode02"
    E válido preço total de reserva "totalOrderPrice02"

@CT10 
Cenário: Post de criação de reserva com um adulto e um bebê em voo GIG/BCN
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "3" junto ao token "bTokenCT03"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken03"
    E válido localizador "reservationCode03"
    E válido preço total de reserva "totalOrderPrice03"
    
    @CT11
Cenário: Post de criação de reserva com nove adultos em voo GRU/BCN
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "4" junto ao token "bTokenCT04"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken04"
    E válido localizador "reservationCode04"
    E válido preço total de reserva "totalOrderPrice04"

    @CT12
Cenário: Post de criação de reserva com um adulto e oito crianças em voo MAD/GIG
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "5" junto ao token "bTokenCT05"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken05"
    E válido localizador "reservationCode05"
    E válido preço total de reserva "totalOrderPrice05"
    
    @CT13
Cenário: Post de criação de reserva com três adultos, três crianças e três bebês em voo GRU/MAD
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "6" junto ao token "bTokenCT06"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken06"
    E válido localizador "reservationCode06"
    E válido preço total de reserva "totalOrderPrice06"    
    
    @CT14
Cenário: Post de criação de reserva com um adulto estrangeiro em voo BCN/GRU
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "7" junto ao token "bTokenCT07"
    Quando envio requisição de reserva de voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 guardando o bookingToken "bookingToken07"
    E válido localizador "reservationCode07"
    E válido preço total de reserva "totalOrderPrice07"        
