### 사회복지사와 독거노인을 위한 IoT - HW 

## WebServer
- JSP WebServer 
- JDBC
- Arduino - python - MySQL - Webserver 

## Arduino
- Python 의 pyserial 을 이용한 시리얼통신 
- sos.py 아두이노에서 버튼이 눌렸을 때 pySerial 을 통한 MySQL 로 데이터가 저장된다. 
- sos.ino 에서는 버튼 연결과 버튼이 눌렸을 때 경보음을 울려주는 코드이다. 
- sos_button.ino 에서 와이파이 통신을 통해 앱에 푸시알림 (+ pushing box & pushbullet) 을 준다.

## Raspberry Pi
- Pi Camera : 
- Temperature & Humidity Sensor
˚ 독거노인의 집에서 사용할 하드웨어로 집 안의 온도와 습도를 30분마다 측정해준다.
˚ 측정된 데이터들은 Firebase RealtimeDataBase 에 저장된다.
