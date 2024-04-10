-- Insertar automovil
INSERT INTO public.automoviles(id, patente, marca, modelo, tipo, anio_fabricacion, motor, cant_asientos, cant_reparaciones, kilometraje)
VALUES (1, 'CFYF55', 'HYUNDAI', 'Getz', 'Sedan', 2010, 'gasolina', 5,1,15000),
       (2, 'TWEQ77', 'HYUNDAI', 'Grand i10', 'Hatchback', 2021, 'gasolina', 5,3,4000),
       (3, 'FHKJ23', 'TOYOTA', 'Corolla', 'Sedan', 2015, 'hibrido', 5,2,10000),
       (4, 'NMQP98', 'FORD', 'Ranger', 'Pickup', 2018, 'diesel', 5,6,35000),
       (5, 'KDJW65', 'CHEVROLET', 'Spark', 'Hatchback', 2019, 'gasolina', 4,9,50000);

--Insertar historial
--INSERT INTO public.historial_reparaciones(id, patente,fecha_ingreso_taller,hora_ingreso_taller, monto_total_pagar, fecha_salida_taller, hora_salida_taller, fecha_cliente_se_lleva_vehiculo, hora_cliente_se_lleva_vehiculo)
--VALUES (1, 'CFYF55','2022-04-15','15:30:00', 0,'2022-04-19','12:30:00', '2022-04-20','15:25:00'),
    --   (2, 'TWEQ77','2023-05-15','12:55:00', 0,'2023-05-19','13:30:00', '2023-05-21','13:27:00');
--INSERT INTO public.historial_reparaciones(id, patente,fecha_ingreso_taller,hora_ingreso_taller, monto_total_pagar, fecha_salida_taller, hora_salida_taller, fecha_cliente_se_lleva_vehiculo, hora_cliente_se_lleva_vehiculo)
--VALUES (1, 'CFYF55','2022-04-15','15:30:00', 270000,'2022-04-19','12:30:00', '2022-04-20','15:25:00'),
--(2, 'TWEQ77','2023-05-15','12:55:00', 260000,'2023-05-19','13:30:00', '2023-05-21','13:27:00');

--Insertar reparaciones
INSERT INTO public.reparaciones(id, patente, descripcion, tipo_reparacion, monto)
VALUES (1, 'CFYF55','Reparacion sistema electrico', 5, 150000),
       (2, 'CFYF55','Reparacion sistema de frenos', 1,120000),
       (3, 'TWEQ77','Reparacion sistema de refrigeracion', 2, 130000),
       (4, 'TWEQ77','Reparacion sistema de combustible', 10, 130000);




















