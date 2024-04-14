--Insertar Bonos
INSERT INTO public.datos_bonos(id, marca_automovil, cantidad_bonos, monto_bono)
VALUES (1, 'Toyota', 5, 70000),
       (2, 'Ford', 2, 50000),
       (3, 'Hyundai', 1, 30000),
       (4, 'Honda', 7, 40000);






-- Insertar automovil
INSERT INTO public.automoviles(id, patente, marca, modelo, tipo, anio_fabricacion, motor, cant_asientos, kilometraje)
VALUES (1, 'CFYF55', 'Hyundai', 'Getz', 'Sedan', 2010, 'Gasolina', 5,15000),
       (2, 'TW6977', 'Hyundai', 'Grand i10', 'Hatchback', 2021, 'Gasolina', 5,4000),
       (3, 'FHKJ23', 'Toyota', 'Corolla', 'Sedan', 2015, 'Hibrido', 5,10000),
       (4, 'NMQP98', 'Ford', 'Ranger', 'Pickup', 2018, 'Diesel', 5,35000),
       (5, 'KDJW65', 'Chevrolet', 'Spark', 'Hatchback', 2019, 'Gasolina', 4,50000);

--Insertar historial
INSERT INTO public.historial_reparaciones(id, patente,fecha_ingreso_taller,hora_ingreso_taller, monto_total_pagar, fecha_salida_taller, hora_salida_taller, fecha_cliente_se_lleva_vehiculo, hora_cliente_se_lleva_vehiculo, descuentos, recargos,iva, pagado)
VALUES (1, 'CFYF55','2024-01-18','10:30:00', 0,'2022-04-19','12:30:00', '2022-04-21','15:25:00',0,0,0, false),
       (2, 'TW6977','2023-12-15','12:55:00', 0,'2023-05-19','13:30:00', '2023-05-21','13:27:00',0,0,0, false),
       (3, 'CFYF55','2024-03-18','10:30:00', 0,'2022-04-19','12:30:00', '2022-04-21','15:25:00',0,0,0,true);
--INSERT INTO public.historial_reparaciones(id, patente,fecha_ingreso_taller,hora_ingreso_taller, monto_total_pagar, fecha_salida_taller, hora_salida_taller, fecha_cliente_se_lleva_vehiculo, hora_cliente_se_lleva_vehiculo)
--VALUES (1, 'CFYF55','2024-01-15','15:30:00', 270000,'2022-04-19','12:30:00', '2022-04-20','15:25:00'),
  --     (2, 'TW6977','2023-01-15','12:55:00', 260000,'2023-05-19','13:30:00', '2023-05-21','13:27:00');









INSERT INTO public.valorreparaciones(id, gasolina, diesel, hibrido, electrico)
VALUES (1, 120000, 120000, 180000, 220000),
       (2, 130000, 130000, 190000, 230000),
       (3, 350000, 450000, 700000, 800000),
       (4, 210000, 210000, 300000, 300000),
       (5, 150000, 150000, 200000, 250000),
       (6, 100000, 120000, 450000, 0),
       (7, 100000, 100000, 100000, 100000),
       (8, 180000, 180000, 210000, 250000),
       (9, 150000, 150000, 180000, 180000),
       (10, 130000, 140000, 220000, 0),
       (11, 80000, 80000, 80000, 80000);



--Insertar reparaciones
INSERT INTO public.reparaciones(id, patente, descripcion, tipo_reparacion, monto, id_reparacion, id_historial_reparaciones)
VALUES (1, 'CFYF55','Reparacion sistema electrico', 5, 150000,5,1),
       (2, 'CFYF55','Reparacion sistema de frenos', 1,120000,1,1),
       (3, 'TW6977','Reparacion sistema de refrigeracion', 2, 130000,2,2),
       (4, 'TW6977','Reparacion sistema de combustible', 10, 130000,10,2),
       (5, 'KDJW65','Reparacion sistema de refrigeracion', 2, 130000,2,2),
       (6, 'CFYF55','Reparacion sistema electrico', 5, 150000,5,3),
       (7, 'CFYF55','Reparacion sistema de combustible', 1,130000,1,3);













