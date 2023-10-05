#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@BookingIssue @Cenário01
Funcionalidade: Validação de post em emissão de reserva para voo ida
    Eu como usuário quero emitir minha reserva aérea somente ida

    @CT01  
    Cenário: Post de emissão de reserva com um adulto em voo ida SAO/RIO 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken01" junto a valor de emissão "totalOrderPrice01"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"
    
    @CT02
    Cenário: Post de emissão de reserva com um adulto e uma criança em voo ida SAO/MAD 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken02" junto a valor de emissão "totalOrderPrice02"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT"    
    
    @CT03
    Cenário: Post de emissão de reserva com um adulto e um bebÊ em voo ida GIG/BPS 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken03" junto a valor de emissão "totalOrderPrice03"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        
    
    @CT04 
    Cenário: Post de emissão de reserva com nove adultos em voo ida MAD/SAO 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken04" junto a valor de emissão "totalOrderPrice04"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT" 
    
    @CT05 
    Cenário: Post de emissão de reserva com um adulto e oito crianças em voo ida BPS/FLN
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken05" junto a valor de emissão "totalOrderPrice05"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        
 
    @CT06 
    Cenário: Post de emissão de reserva com três adultos, três crianças e três bebês em voo ida FLN/GRU
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken06" junto a valor de emissão "totalOrderPrice06"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT" 
   
    @CT07 
    Cenário: Post de emissão de emissão com um adulto estrangeiro em voo ida DXB/GRU
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken07" junto a valor de emissão "totalOrderPrice07"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        

    
            