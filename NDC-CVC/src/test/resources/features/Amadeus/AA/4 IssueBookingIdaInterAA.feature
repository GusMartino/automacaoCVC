#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@BookingIssueInter @Cenário04
Funcionalidade: Validação de post em emissão de reserva para voo ida da companhia American Airlines
    Eu como usuário quero emitir minha reserva aérea somente ida da companhia American Airlines


    Cenário: Post de emissão de reserva com um adulto em voo ida MIA/LGA 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken01" junto a valor de emissão "totalOrderPrice01"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "AMAD"
    

    Cenário: Post de emissão de reserva com um adulto e uma criança em voo ida GRU/MIA 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken02" junto a valor de emissão "totalOrderPrice02"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "AMAD"    
    

    Cenário: Post de emissão de reserva com um adulto e um bebÊ em voo ida GIG/LAS 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken03" junto a valor de emissão "totalOrderPrice03"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "AMAD"        
    
    
    Cenário: Post de emissão de reserva com nove adultos em voo ida LAS/GRU 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken04" junto a valor de emissão "totalOrderPrice04"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "AMAD" 
    

    Cenário: Post de emissão de reserva com um adulto e oito crianças em voo ida GIG/MIA
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken05" junto a valor de emissão "totalOrderPrice05"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "AMAD"        
 

    Cenário: Post de emissão de reserva com três adultos, três crianças e três bebês em voo ida GRU/BOS
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken06" junto a valor de emissão "totalOrderPrice06"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "AMAD" 
   

    Cenário: Post de emissão de emissão com um adulto estrangeiro em voo ida BOS/GIG
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "bookingToken07" junto a valor de emissão "totalOrderPrice07"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "AMAD"        

    
            