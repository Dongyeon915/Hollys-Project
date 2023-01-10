SELECT * FROM hollys.product;
alter table menu convert to character set utf8;

-- 에스프레소 
INSERT INTO hollys.product VALUES (NULL, "프리미엄 블렌드 아메리카노", "Premium Blend Americano", "화사한 산미와 과일과 같은 달콤함, 깔끔한 후미를 즐길수 있는 커피", 4900, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202205100954143020.png", 1);
INSERT INTO hollys.product VALUES (NULL, "윈터 티라미수 라떼", "Winter Tiramisu Latte", "부드러운 치즈의 풍미와 커피의 향이 조화로운 티라미수 라떼", 6800, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202211030915138420.png", 1);
INSERT INTO hollys.product VALUES (NULL, "아메리카노", "Caffe Americano", "진한 에스프레소의 맛과 향을 부드럽게 즐길 수 있는 아메리칸 스타일의 커피", 4500, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202208310252263900.png", 1);
INSERT INTO hollys.product VALUES (NULL, "프리미엄 블렌드 딥라떼", "Premium Blend Deep Latte", "풍성한 우유 거품 위에 프리미엄 블렌드 리스트레또 샷이 더해져 깊은 커피 풍미를 느낄 수 있는 라떼", 5400, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202210110501025020.png", 1);
INSERT INTO hollys.product VALUES (NULL, "카페라떼", "Caffe Latte", "진한 에스프레소에 우유를 넣어 풍부한 커피향을 부드럽게 즐길 수 있는 커피", 5000, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202208310252574560.png", 1);
INSERT INTO hollys.product VALUES (NULL, "카페모카", "Caffe Mocha", "진한 에스프레소와 우유, 달콤 쌉싸름한 초콜릿이 어우러진 커피", 5500, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202210310251043970.png", 1);
INSERT INTO hollys.product VALUES (NULL, "카라멜 마키아또", "Caramel Macchiato", "진한 에스프레소에 바닐라 시럽과 카라멜소스가 더해진 카라멜 커피음료의 대표", 5900, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202210310250489580.png", 1);
INSERT INTO hollys.product VALUES (NULL, "바닐라딜라이트", "Vanilla Delight", "카페라떼에 바닐라빈으로 만든 바닐라 파우더를 더해 더욱 풍부하고 감미로운 할리스만의 바닐라라떼", 5800, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202210110500272440.png", 1);
INSERT INTO hollys.product VALUES (NULL, "리스트레또 딜라이트", "Ristretto Delight", "달콤한 연유와 고소한 할리스 원두, 크리미한 바디가 절묘하게 어우러진 시즌 스페셜 메뉴", 5800, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202210310250218710.png", 1);

-- 디카페인
INSERT INTO hollys.product VALUES (NULL, "디카페인 아메리카노", "Americano (Decaf blend)", "듀얼브루 원액으로 만든 부드러운 풍미와 균형잡힌 바디감의 디카페인 아메리카노", 4900, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202210310249534340.png", 2);
INSERT INTO hollys.product VALUES (NULL, "디카페인 카페라떼", "Caffe Latte (Decaf blend)", "듀얼브루 원액으로 만든 부드러운 풍미와 균형 잡힌 바디감의 디카페인 카페라떼", 5400, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202205100952274340.png", 2);
INSERT INTO hollys.product VALUES (NULL, "디카페인 바닐라 딜라이트", "Vanilla Delight (Decaf blend)", "듀얼브루 원액으로 만들어 더욱 부드럽고 편안해진 바닐라 딜라이트 (*바닐라 딜라이트 제조에 사용되는 파우더에 카페인이 일부 함유되어 있음)", 6200, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202210310248502260.png", 2);

-- 콜드브루
INSERT INTO hollys.product VALUES (NULL, "콜드브루", "Cold Brew", "콜드브루 전용 블렌드를 상온의 물로 오랜시간 추출해 달콤한 산미와 부드러운 바디감이 살아있는 커피", 4900, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202211210948287330.png", 3);
INSERT INTO hollys.product VALUES (NULL, "콜드브루 라떼", "Cold Brew Latte", "콜드브루 커피의 풍부한 풍미와 우유의 고소함이 더해진 라떼", 5400, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202205100953196550.png", 3);
INSERT INTO hollys.product VALUES (NULL, "콜드브루 딜라이트", "Cold Brew Delight", "실키한 연유베이스에 콜드브루를 넣어 부담없이 즐기는 라떼", 6200, "https://admin.hollys.co.kr/upload/menu/etc/menuEtc_202209050523340280.png", 3);

SELECT * FROM product;
SELECT * FROM product LEFT JOIN category ON product.category_fk = category_id LEFT JOIN menu ON menu_fk = menu.menu_id;
SELECT id, product.name, name_eng, info, price, image_url, menu.name, type FROM product LEFT JOIN category ON product.category_fk = category_id LEFT JOIN menu ON menu_fk = menu.menu_id;
