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










-- Reparaciones del Sistema de Frenos
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor, numero_reparacion)
VALUES (1, 'Incluye el reemplazo de pastillas de freno, discos, tambores, líneas de freno y Reparacioon o reemplazo del cilindro maestro de frenos.', 'Reparaciones del Sistema de Frenos', 120000, 'Gasolina',1),
       (2, 'Incluye el reemplazo de pastillas de freno, discos, tambores, líneas de freno y Reparacioon o reemplazo del cilindro maestro de frenos.', 'Reparaciones del Sistema de Frenos', 120000, 'Diesel',1),
       (3, 'Incluye el reemplazo de pastillas de freno, discos, tambores, líneas de freno y Reparacioon o reemplazo del cilindro maestro de frenos.', 'Reparaciones del Sistema de Frenos', 180000, 'Hibrido',1),
       (4, 'Incluye el reemplazo de pastillas de freno, discos, tambores, líneas de freno y Reparacioon o reemplazo del cilindro maestro de frenos.', 'Reparaciones del Sistema de Frenos', 220000, 'Electrico',1);

-- Servicio del Sistema de Refrigeración
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (5, 'Reparacioon o reemplazo de radiadores, bombas de agua, termostatos y mangueras, así como la solución de problemas de sobrecalentamiento.', 'Servicio del Sistema de Refrigeración', 130000, 'Gasolina',2),
       (6, 'Reparacioon o reemplazo de radiadores, bombas de agua, termostatos y mangueras, así como la solución de problemas de sobrecalentamiento.', 'Servicio del Sistema de Refrigeración', 130000, 'Diesel',2),
       (7, 'Reparacioon o reemplazo de radiadores, bombas de agua, termostatos y mangueras, así como la solución de problemas de sobrecalentamiento.', 'Servicio del Sistema de Refrigeración', 190000, 'Hibrido',2),
       (8, 'Reparacioon o reemplazo de radiadores, bombas de agua, termostatos y mangueras, así como la solución de problemas de sobrecalentamiento.', 'Servicio del Sistema de Refrigeración', 230000, 'Electrico',2);

-- Reparaciones del Motor
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (9, 'Desde reparaciones menores como el reemplazo de bujías y cables, hasta reparaciones mayores como la reconstrucción del motor o la Reparacioon de la junta de la culata.', 'Reparaciones del Motor', 350000, 'Gasolina',3),
       (10, 'Desde reparaciones menores como el reemplazo de bujías y cables, hasta reparaciones mayores como la reconstrucción del motor o la Reparacioon de la junta de la culata.', 'Reparaciones del Motor', 450000, 'Diesel',3),
       (11, 'Desde reparaciones menores como el reemplazo de bujías y cables, hasta reparaciones mayores como la reconstrucción del motor o la Reparacioon de la junta de la culata.', 'Reparaciones del Motor', 700000, 'Hibrido',3),
       (12, 'Desde reparaciones menores como el reemplazo de bujías y cables, hasta reparaciones mayores como la reconstrucción del motor o la Reparacioon de la junta de la culata.', 'Reparaciones del Motor', 800000, 'Electrico',3);

-- Reparaciones de la Transmisión
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (13, 'Incluyen la Reparacioon o reemplazo de componentes de la transmisión manual o automática, cambios de líquido y solución de problemas de cambios de marcha.', 'Reparaciones de la Transmisión', 210000, 'Gasolina',4),
       (14, 'Incluyen la Reparacioon o reemplazo de componentes de la transmisión manual o automática, cambios de líquido y solución de problemas de cambios de marcha.', 'Reparaciones de la Transmisión', 210000, 'Diesel',4),
       (15, 'Incluyen la Reparacioon o reemplazo de componentes de la transmisión manual o automática, cambios de líquido y solución de problemas de cambios de marcha.', 'Reparaciones de la Transmisión', 300000, 'Hibrido',4),
       (16, 'Incluyen la Reparacioon o reemplazo de componentes de la transmisión manual o automática, cambios de líquido y solución de problemas de cambios de marcha.', 'Reparaciones de la Transmisión', 300000, 'Electrico',4);

-- Reparaciones del Sistema Electrico
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (17, 'Solución de problemas y Reparacioon de alternadores, arrancadores, baterías y sistemas de cableado, así como la Reparacioon de componentes Electricos como faros, intermitentes y sistemas de entretenimiento.', 'Reparaciones del Sistema Electrico', 150000, 'Gasolina',5),
       (18, 'Solución de problemas y Reparacioon de alternadores, arrancadores, baterías y sistemas de cableado, así como la Reparacioon de componentes Electricos como faros, intermitentes y sistemas de entretenimiento.', 'Reparaciones del Sistema Electrico', 150000, 'Diesel',5),
       (19, 'Solución de problemas y Reparacioon de alternadores, arrancadores, baterías y sistemas de cableado, así como la Reparacioon de componentes Electricos como faros, intermitentes y sistemas de entretenimiento.', 'Reparaciones del Sistema Electrico', 200000, 'Hibrido',5),
       (20, 'Solución de problemas y Reparacioon de alternadores, arrancadores, baterías y sistemas de cableado, así como la Reparacioon de componentes Electricos como faros, intermitentes y sistemas de entretenimiento.', 'Reparaciones del Sistema Electrico', 250000, 'Electrico',5);

-- Reparaciones del Sistema de Escape
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (21, 'Incluye el reemplazo del silenciador, tubos de escape, catalizador y la solución de problemas relacionados con las emisiones.', 'Reparaciones del Sistema de Escape', 100000, 'Gasolina',6),
       (22, 'Incluye el reemplazo del silenciador, tubos de escape, catalizador y la solución de problemas relacionados con las emisiones.', 'Reparaciones del Sistema de Escape', 120000, 'Diesel',6),
       (23, 'Incluye el reemplazo del silenciador, tubos de escape, catalizador y la solución de problemas relacionados con las emisiones.', 'Reparaciones del Sistema de Escape', 450000, 'Hibrido',6),
       (24, 'Incluye el reemplazo del silenciador, tubos de escape, catalizador y la solución de problemas relacionados con las emisiones.', 'Reparaciones del Sistema de Escape', 0, 'Electrico',6);

-- Reparacioon de Neumáticos y Ruedas
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (25, 'Reparacioon de pinchazos, reemplazo de neumáticos, alineación y balanceo de ruedas.', 'Reparacioon de Neumáticos y Ruedas', 100000, 'Gasolina',7),
       (26, 'Reparacioon de pinchazos, reemplazo de neumáticos, alineación y balanceo de ruedas.', 'Reparacioon de Neumáticos y Ruedas', 100000, 'Diesel',7),
       (27, 'Reparacioon de pinchazos, reemplazo de neumáticos, alineación y balanceo de ruedas.', 'Reparacioon de Neumáticos y Ruedas', 100000, 'Hibrido',7),
       (28, 'Reparacioon de pinchazos, reemplazo de neumáticos, alineación y balanceo de ruedas.', 'Reparacioon de Neumáticos y Ruedas', 100000, 'Electrico',7);

-- Reparaciones de la Suspensión y la Dirección
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (29, 'Reemplazo de amortiguadores, brazos de control, rótulas y Reparacioon del sistema de dirección asistida.', 'Reparaciones de la Suspensión y la Dirección', 180000, 'Gasolina',8),
       (30, 'Reemplazo de amortiguadores, brazos de control, rótulas y Reparacioon del sistema de dirección asistida.', 'Reparaciones de la Suspensión y la Dirección', 180000, 'Diesel',8),
       (31, 'Reemplazo de amortiguadores, brazos de control, rótulas y Reparacioon del sistema de dirección asistida.', 'Reparaciones de la Suspensión y la Dirección', 210000, 'Hibrido',8),
       (32, 'Reemplazo de amortiguadores, brazos de control, rótulas y Reparacioon del sistema de dirección asistida.', 'Reparaciones de la Suspensión y la Dirección', 250000, 'Electrico',8);

-- Reparacioon del Sistema de Aire Acondicionado y Calefacción
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (33, 'Incluye la recarga de refrigerante, Reparacioon o reemplazo del compresor, y solución de problemas del sistema de calefacción.', 'Reparacioon del Sistema de Aire Acondicionado y Calefacción', 150000, 'Gasolina',9),
       (34, 'Incluye la recarga de refrigerante, Reparacioon o reemplazo del compresor, y solución de problemas del sistema de calefacción.', 'Reparacioon del Sistema de Aire Acondicionado y Calefacción', 150000, 'Diesel',9),
       (35, 'Incluye la recarga de refrigerante, Reparacioon o reemplazo del compresor, y solución de problemas del sistema de calefacción.', 'Reparacioon del Sistema de Aire Acondicionado y Calefacción', 180000, 'Hibrido',9),
       (36, 'Incluye la recarga de refrigerante, Reparacioon o reemplazo del compresor, y solución de problemas del sistema de calefacción.', 'Reparacioon del Sistema de Aire Acondicionado y Calefacción', 180000, 'Electrico',9);

-- Reparaciones del Sistema de Combustible
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (37, 'Limpieza o reemplazo de inyectores de combustible, Reparacioon o reemplazo de la bomba de combustible y solución de problemas de suministro de combustible.', 'Reparaciones del Sistema de Combustible', 130000, 'Gasolina',10),
       (38, 'Limpieza o reemplazo de inyectores de combustible, Reparacioon o reemplazo de la bomba de combustible y solución de problemas de suministro de combustible.', 'Reparaciones del Sistema de Combustible', 140000, 'Diesel',10),
       (39, 'Limpieza o reemplazo de inyectores de combustible, Reparacioon o reemplazo de la bomba de combustible y solución de problemas de suministro de combustible.', 'Reparaciones del Sistema de Combustible', 220000, 'Hibrido',10),
       (40, 'Limpieza o reemplazo de inyectores de combustible, Reparacioon o reemplazo de la bomba de combustible y solución de problemas de suministro de combustible.', 'Reparaciones del Sistema de Combustible', 0, 'Electrico',10);

-- Reparacioon y Reemplazo del Parabrisas y Cristales
INSERT INTO public.valorreparaciones(id, descripcion, tipo_reparacion, monto, tipo_motor,numero_reparacion)
VALUES (41, 'Reparacion de pequeñas grietas en el parabrisas o reemplazo completo de parabrisas y ventanas dañadas.', 'Reparacioon y Reemplazo del Parabrisas y Cristales', 80000, 'Gasolina',11),
       (42, 'Reparacion de pequeñas grietas en el parabrisas o reemplazo completo de parabrisas y ventanas dañadas.', 'Reparacioon y Reemplazo del Parabrisas y Cristales', 80000, 'Diesel',11),
       (43, 'Reparacion de pequeñas grietas en el parabrisas o reemplazo completo de parabrisas y ventanas dañadas.', 'Reparacioon y Reemplazo del Parabrisas y Cristales', 80000, 'Hibrido',11),
       (44, 'Reparacion de pequeñas grietas en el parabrisas o reemplazo completo de parabrisas y ventanas dañadas.', 'Reparacioon y Reemplazo del Parabrisas y Cristales', 80000, 'Electrico',11);





--Insertar reparaciones
INSERT INTO public.reparaciones(id, patente, descripcion, tipo_reparacion, id_historial_reparaciones)
VALUES (1, 'CFYF55','Reparacion sistema electrico', 5,1),
       (2, 'CFYF55','Reparacion sistema de frenos', 1,1),
       (3, 'TW6977','Reparacion sistema de refrigeracion', 1, 2),
       (4, 'TW6977','Reparacion sistema de combustible', 10,2),
       (5, 'KDJW65','Reparacion sistema de refrigeracion', 2,2),
       (6, 'CFYF55','Reparacion sistema electrico', 5,3),
       (7, 'CFYF55','Reparacion sistema de combustible', 1,3);













