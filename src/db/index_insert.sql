INSERT INTO dbo.proveedor (activo, contacto, direccion, email, razon_social, ruc, telefono) VALUES
                                                                                                (1, 'Carlos Mendoza', 'Av. Argentina 1245, Lima', 'ventas@alicorpperu.com', 'Alicorp S.A.A.', '20100055237', '01-315-0000'),
                                                                                                (1, 'Maria Rodriguez', 'Jr. Cusco 567, La Victoria, Lima', 'comercial@gloriafoods.pe', 'Gloria Foods S.A.', '20100190797', '01-470-9000'),
                                                                                                (1, 'Jose Gutierrez', 'Av. Industrial 890, Ate, Lima', 'pedidos@ajeper.com.pe', 'Ajeper S.A.', '20338440633', '01-349-2000'),
                                                                                                (1, 'Ana Vargas', 'Calle Los Eucaliptos 432, San Isidro, Lima', 'ventas@redondos.pe', 'Productos Redondos S.A.C.', '20123456789', '01-442-7500'),
                                                                                                (1, 'Luis Paredes', 'Av. Javier Prado 1678, San Borja, Lima', 'comercial@distribuidorainca.pe', 'Distribuidora Inca S.R.L.', '20987654321', '01-225-8800');


INSERT INTO dbo.tipo_producto (nombre) VALUES
                                           ('Abarrotes'),
                                           ('Bebidas'),
                                           ('Lácteos'),
                                           ('Carnes'),
                                           ('Frutas y Verduras'),
                                           ('Panadería'),
                                           ('Limpieza'),
                                           ('Cuidado Personal');

INSERT INTO dbo.producto (activo, barcode, created_at, created_by, descripcion, nombre, precio_costo, precio_venta, sku, stock_max, stock_min, unidad_medida, updated_at, updated_by, tipo_producto_id) VALUES
                                                                                                                                                                                                            (1, '7751271001014', GETDATE(), 1, 'Arroz superior extra seleccionado', 'Arroz Costeño 1kg', 3.50, 4.20, 'ARR001', 100, 10, 'kg', GETDATE(), 1, 1),
                                                                                                                                                                                                            (1, '7750885005807', GETDATE(), 1, 'Aceite vegetal puro de soya', 'Aceite Primor 1L', 6.80, 8.50, 'ACE001', 80, 8, 'L', GETDATE(), 1, 1),
                                                                                                                                                                                                            (1, '7754100004526', GETDATE(), 1, 'Azúcar blanca refinada', 'Azúcar Cartavio 1kg', 2.20, 2.80, 'AZU001', 120, 15, 'kg', GETDATE(), 1, 1),
                                                                                                                                                                                                            (1, '7750182003421', GETDATE(), 1, 'Gaseosa sabor cola', 'Coca Cola 500ml', 1.80, 2.50, 'COC001', 200, 20, 'unidad', GETDATE(), 1, 2),
                                                                                                                                                                                                            (1, '7751271005012', GETDATE(), 1, 'Leche evaporada entera', 'Leche Gloria 400g', 3.20, 4.00, 'LEG001', 150, 25, 'unidad', GETDATE(), 1, 3),
                                                                                                                                                                                                            (1, '7751271008456', GETDATE(), 1, 'Queso fresco pasteurizado', 'Queso Gloria 250g', 4.50, 6.20, 'QUE001', 60, 8, 'unidad', GETDATE(), 1, 3),
                                                                                                                                                                                                            (1, '7751002001015', GETDATE(), 1, 'Pollo beneficiado fresco', 'Pollo Entero San Fernando', 14.00, 18.00, 'POL001', 50, 5, 'kg', GETDATE(), 1, 4),
                                                                                                                                                                                                            (1, '0000000000001', GETDATE(), 1, 'Papa blanca de primera calidad', 'Papa Blanca', 2.50, 3.50, 'PAP001', 100, 10, 'kg', GETDATE(), 1, 5),
                                                                                                                                                                                                            (1, '7750885008742', GETDATE(), 1, 'Pan de molde integral', 'Pan Bimbo Integral 500g', 3.80, 5.20, 'PAN001', 40, 5, 'unidad', GETDATE(), 1, 6),
                                                                                                                                                                                                            (1, '7751002008963', GETDATE(), 1, 'Detergente en polvo concentrado', 'Ariel 1kg', 8.50, 12.00, 'DET001', 70, 10, 'unidad', GETDATE(), 1, 7);

INSERT INTO dbo.usuario
(activo, created_at, created_by, email, nombre, password_hash, updated_at, updated_by, username)
VALUES
    (1, SYSUTCDATETIME(), 1, 'usuario@ejemplo.com', 'Juan Pérez', 'REPLACE_WITH_BCRYPT_HASH', NULL, NULL, 'juanperez');
