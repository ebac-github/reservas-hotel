# Sistema de Reservas de Hotel

## Descrição

Este é um sistema simples para gerenciamento de reservas de quartos em um hotel.  
Permite cadastrar reservas, listar todas as reservas feitas, buscar reservas pelo nome do hóspede e ordenar as reservas pelo número de dias da estadia em ordem decrescente.

---

## Funcionalidades

- Adicionar nova reserva com as seguintes informações:
    - Nome do hóspede
    - Tipo do quarto (Standard, Luxo ou Presidencial)
    - Número de dias da estadia
    - Valor da diária
- Listar todas as reservas cadastradas
- Buscar reservas pelo nome do hóspede (busca por termo dentro do nome)
- Ordenar reservas pelo número de dias (do maior para o menor)
- Limite máximo de 10 reservas no sistema
- Interface via menu no terminal

---

## Como executar

1. Clone o repositório ou baixe os arquivos fonte.
2. Depois abre em uma IDE e execute a classe principal "SistemaDeReservasDeHotel"
3. Ou compile os arquivos `.java`, sem usar uma IDE (exemplo usando terminal):
   ```bash
   javac *.java
