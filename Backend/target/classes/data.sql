-- Insertar automovil
INSERT INTO public.automoviles(id, patente, marca, modelo, tipo, anio_fabricacion, tipo_motor, cant_asientos)
VALUES (1, 'CFGF55', 'HYUNDAI', 'Getz', 'Sedan', 2010, 'gasolina', 5),
       (2, 'TWEQ77', 'HYUNDAI', 'Grand i10', 'Hatchback', 2021, 'gasolina', 5),
       (3, 'FHKJ23', 'TOYOTA', 'Corolla', 'Sedan', 2015, 'hibrido', 5),
       (4, 'NMQP98', 'FORD', 'Ranger', 'Pickup', 2018, 'diesel', 5),
       (5, 'KDJW65', 'CHEVROLET', 'Spark', 'Hatchback', 2019, 'gasolina', 4);


--Insertar Descuentos
INSERT INTO public.descuentos(id, tipo_descuento, cant_reparaciones_min, cant_reparaciones_max, marca_vehiculo, tipo_motor, cantidad_bonos, monto_bono, dia_inicio_descuento, dia_fin_descuento, porcentaje_descuento)
VALUES (1, 'Reparaciones', 1, 2, null, 'Gasolina', 0, 0, null, null,0.05),
       (2, 'Reparaciones', 1, 2, null, 'Diesel', 0, 0, null, null,0.07),
       (3, 'Reparaciones', 1, 2, null, 'Hibrido', 0, 0, null, null,0.1),
       (4, 'Reparaciones', 1, 2, null, 'Electrico', 0, 0, null, null,0.08),
       (5, 'Reparaciones', 3, 5, null, 'Gasolina', 0, 0, null, null,0.1),
       (6, 'Reparaciones', 3, 5, null, 'Diesel', 0, 0, null, null,0.12),
       (7, 'Reparaciones', 3, 5, null, 'Hibrido', 0, 0, null, null,0.15),
       (8, 'Reparaciones', 3, 5, null, 'Electrico', 0, 0, null, null,0.13),
       (9, 'Reparaciones', 6, 9, null, 'Gasolina', 0, 0, null, null,0.15),
       (10, 'Reparaciones', 6, 9, null, 'Diesel', 0, 0, null, null,0.17),
       (11, 'Reparaciones', 6, 9, null, 'Hibrido', 0, 0, null, null,0.2),
       (12, 'Reparaciones', 6, 9, null, 'Electrico', 0, 0, null, null,0.18),
       (13, 'Reparaciones', 10, 999, null, 'Gasolina', 0, 0, null, null,0.2),
       (14, 'Reparaciones', 10, 999, null, 'Diesel', 0, 0, null, null,0.22),
       (15, 'Reparaciones', 10, 999, null, 'Hibrido', 0, 0, null, null,0.25),
       (16, 'Reparaciones', 10, 999, null, 'Electrico', 0, 0, null, null,0.23),
       (17, 'Bono', 0, 0, 'Toyota', null, 5, 70000,null, null, 0),
       (18, 'Bono', 0, 0, 'Ford', null, 2, 50000, null, null, 0),
       (19, 'Bono', 0, 0, 'Hyundai', null, 1, 30000, null, null, 0),
       (20, 'Bono', 0, 0, 'Honda', null, 7, 40000, null, null, 0);


--Insertar Recargos
INSERT INTO public.recargos(id, tipo_recargo, rango_antiguedad_minimo, rango_antiguedad_maximo, rango_kilometraje_minimo, rango_kilometraje_maximo, tipo_vehiculo, porcentaje_recargo)
VALUES (1, 'Antiguedad', 0, 5, 0, 0, 'Sedan', 0),
       (2, 'Antiguedad', 0, 5, 0, 0, 'Hatchback', 0),
       (3, 'Antiguedad', 0, 5, 0, 0, 'Suv', 0),
       (4, 'Antiguedad', 0, 5, 0, 0, 'Pickup', 0),
       (5, 'Antiguedad', 0, 5, 0, 0, 'Furgoneta', 0),

       (6, 'Antiguedad', 6, 10, 0, 0, 'Sedan', 0.05),
       (7, 'Antiguedad', 6, 10, 0, 0, 'Hatchback', 0.05),
       (8, 'Antiguedad', 6, 10, 0, 0, 'Suv', 0.07),
       (9, 'Antiguedad', 6, 10, 0, 0, 'Pickup', 0.07),
       (10, 'Antiguedad', 6, 10, 0, 0, 'Furgoneta', 0.07),

       (11, 'Antiguedad', 11, 15, 0, 0, 'Sedan', 0.09),
       (12, 'Antiguedad', 11, 15, 0, 0, 'Hatchback', 0.09),
       (13, 'Antiguedad', 11, 15, 0, 0, 'Suv', 0.11),
       (14, 'Antiguedad', 11, 15, 0, 0, 'Pickup', 0.11),
       (15, 'Antiguedad', 11, 15, 0, 0, 'Furgoneta', 0.11),

       (16, 'Antiguedad', 16, 999, 0, 0, 'Sedan', 0.15),
       (17, 'Antiguedad', 16, 999, 0, 0, 'Hatchback', 0.15),
       (18, 'Antiguedad', 16, 999, 0, 0, 'Suv', 0.2),
       (19, 'Antiguedad', 16, 999, 0, 0, 'Pickup', 0.2),
       (20, 'Antiguedad', 16, 999, 0, 0, 'Furgoneta', 0.2),

---------------------------------------

       (21, 'Kilometraje', 0, 0, 0, 5000, 'Sedan', 0),
       (22, 'Kilometraje', 0, 0, 0, 5000, 'Hatchback', 0),
       (23, 'Kilometraje', 0, 0, 0, 5000, 'Suv', 0),
       (24, 'Kilometraje', 0, 0, 0, 5000, 'Pickup', 0),
       (25, 'Kilometraje', 0, 0, 0, 5000, 'Furgoneta', 0),


       (26, 'Kilometraje', 0, 0, 5001, 12000, 'Sedan', 0.03),
       (27, 'Kilometraje', 0, 0, 5001, 12000, 'Hatchback', 0.03),
       (28, 'Kilometraje', 0, 0, 5001, 12000, 'Suv', 0.05),
       (29, 'Kilometraje', 0, 0, 5001, 12000, 'Pickup', 0.05),
       (30, 'Kilometraje', 0, 0, 5001, 12000, 'Furgoneta', 0.05),

       (31, 'Kilometraje', 0, 0, 12001, 25000, 'Sedan', 0.07),
       (32, 'Kilometraje', 0, 0, 12001, 25000, 'Hatchback', 0.07),
       (33, 'Kilometraje', 0, 0, 12001, 25000, 'Suv', 0.09),
       (34, 'Kilometraje', 0, 0, 12001, 25000, 'Pickup', 0.09),
       (35, 'Kilometraje', 0, 0, 12001, 25000, 'Furgoneta', 0.09),

       (36, 'Kilometraje', 0, 0, 25001, 40000, 'Sedan', 0.12),
       (37, 'Kilometraje', 0, 0, 25001, 40000, 'Hatchback', 0.12),
       (38, 'Kilometraje', 0, 0, 25001, 40000, 'Suv', 0.12),
       (39, 'Kilometraje', 0, 0, 25001, 40000, 'Pickup', 0.12),
       (40, 'Kilometraje', 0, 0, 25001, 40000, 'Furgoneta', 0.12),

       (41, 'Kilometraje', 0, 0, 40001, 9999999, 'Sedan', 0.2),
       (42, 'Kilometraje', 0, 0, 40001, 9999999, 'Hatchback', 0.2),
       (43, 'Kilometraje', 0, 0, 40001, 9999999, 'Suv', 0.2),
       (44, 'Kilometraje', 0, 0, 40001, 9999999, 'Pickup', 0.2),
       (45, 'Kilometraje', 0, 0, 40001, 9999999, 'Furgoneta', 0.2);

























