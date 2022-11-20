INSERT INTO PONTOS(PONTO_ID, LATITUDE, LONGITUDE) VALUES (0, 0, 0);
INSERT INTO PONTOS(PONTO_ID, LATITUDE, LONGITUDE) VALUES (1, -10, 3);
INSERT INTO PONTOS(PONTO_ID, LATITUDE, LONGITUDE) VALUES (2, 1, 10);
INSERT INTO PONTOS(PONTO_ID, LATITUDE, LONGITUDE) VALUES (3, 7, -5);
INSERT INTO PONTOS(PONTO_ID, LATITUDE, LONGITUDE) VALUES (4, -6, -6);

INSERT INTO AEROPORTOS(AEROPORTO_ID, PONTO, CIDADE, NOME  ) VALUES (1, 1, 'Cidade_1', 'A1');
INSERT INTO AEROPORTOS(AEROPORTO_ID, PONTO, CIDADE, NOME  ) VALUES (2, 2, 'Cidade_2', 'A2');
INSERT INTO AEROPORTOS(AEROPORTO_ID, PONTO, CIDADE, NOME  ) VALUES (3, 3, 'Cidade_3', 'A3');
INSERT INTO AEROPORTOS(AEROPORTO_ID, PONTO, CIDADE, NOME  ) VALUES (4, 4, 'Cidade_4', 'A4');

INSERT INTO ROTAS(ROTA_ID, ORIGEM_AEROPORTO_ID, DESTINO_AEROPORTO_ID) VALUES (1, 1, 2); 
INSERT INTO ROTAS(ROTA_ID, ORIGEM_AEROPORTO_ID, DESTINO_AEROPORTO_ID) VALUES (2, 2, 1); 
INSERT INTO ROTAS(ROTA_ID, ORIGEM_AEROPORTO_ID, DESTINO_AEROPORTO_ID) VALUES (3, 1, 2); 
INSERT INTO ROTAS(ROTA_ID, ORIGEM_AEROPORTO_ID, DESTINO_AEROPORTO_ID) VALUES (4, 1, 4); 
INSERT INTO ROTAS(ROTA_ID, ORIGEM_AEROPORTO_ID, DESTINO_AEROPORTO_ID) VALUES (5, 1, 3); 
INSERT INTO ROTAS(ROTA_ID, ORIGEM_AEROPORTO_ID, DESTINO_AEROPORTO_ID) VALUES (6, 3, 2); 
INSERT INTO ROTAS(ROTA_ID, ORIGEM_AEROPORTO_ID, DESTINO_AEROPORTO_ID) VALUES (7, 3, 4); 

INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 1, 1, 2,  1);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 2, 2, 1,  2);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 3, 3, 2,  3);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 4, 1, 0,  4);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 5, 4, 1,  5);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 6, 0, 4,  6);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 7, 0, 3,  7);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 8, 4, 3,  8);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES ( 9, 4, 3,  9);
INSERT INTO AEROVIAS(AEROVIA_ID, PONTO_ORIGEM, PONTO_DESTINO, DISTANCIA) VALUES (10, 2, 0, 10);

INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(1, 1);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(2, 2);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(3, 4);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(3, 7);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(3, 3);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(4, 4);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(4, 5);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(5, 4);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(5, 7);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(6, 3);
INSERT INTO AEROVIA_ROTA(ROTA_ID, AEROVIA_ID) VALUES(7, 9);

INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (1, 1, '2022-09-11 20:00:00', 'CONFIRMADO');
INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (2, 3, '2022-09-11 20:00:00', 'CONFIRMADO');
INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (3, 4, '2022-09-11 20:00:00', 'CONFIRMADO');
INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (4, 6, '2022-09-11 20:00:00', 'CONFIRMADO');
INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (5, 7, '2022-09-11 20:00:00', 'CONFIRMADO');
INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (6, 1, '2022-09-11 20:00:00', 'CONFIRMADO');
INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (7, 2, '2022-09-11 20:00:00', 'CONFIRMADO');
INSERT INTO VOOS(VOO_ID, ROTA_ID, DATA, STATUS) VALUES (8, 5, '2022-09-11 20:00:00', 'CONFIRMADO');

SELECT * FROM AEROPORTOS;
SELECT * FROM AEROVIAS;
SELECT * FROM PONTOS;
SELECT * FROM ROTAS;
SELECT * FROM AEROVIA_ROTA;
SELECT * FROM VOOS;
SELECT * FROM ALUGUEL;


-- INSERT INTO ROTAS VALUES (1, 1, 2); -- AV1
-- INSERT INTO ROTAS VALUES (2, 2, 1); -- AV2
-- INSERT INTO ROTAS VALUES (3, 1, 2); -- AV4 AV7 AV3
-- INSERT INTO ROTAS VALUES (4, 1, 4); -- AV4 AV5
-- INSERT INTO ROTAS VALUES (5, 1, 3); -- AV4 AV7
-- INSERT INTO ROTAS VALUES (6, 3, 2); -- AV3
-- INSERT INTO ROTAS VALUES (7, 3, 4); -- AV9
