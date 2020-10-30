### 사회복지사와 독거노인을 위한 IoT - HW 

## WebServer
- JSP WebServer 
- JDBC
- Arduino - python - MySQL - Webserver 

## Arduino
: 독거노인이 외출시 사용하는 휴대용기기  (sos 호출)
- Python 의 pyserial 을 이용한 시리얼통신 
- sos.py 아두이노에서 버튼이 눌렸을 때 pySerial 을 통한 MySQL 로 데이터가 저장된다. 
- sos.ino 에서는 버튼 연결과 버튼이 눌렸을 때 경보음을 울려주는 코드이다. 
- sos_button.ino 에서 와이파이 통신을 통해 앱에 푸시알림 (+ pushing box & pushbullet) 을 준다.
<img src="https://user-images.githubusercontent.com/48972530/97693423-80297b80-1ae4-11eb-9ffd-e139cf720a66.PNG"  width="400" height="420"><img src="https://user-images.githubusercontent.com/48972530/97692639-5facf180-1ae3-11eb-9185-99711f0648ea.png"  width="400" height="450">

## Raspberry Pi
: 독거노인의 집에서 사용할 하드웨어 (카메라 & 온습도 센서) 
- Pi Camera : 
- Temperature & Humidity Sensor: 집 안의 온도와 습도를 30분마다 측정해주며 측정된 데이터들은 Firebase RealtimeDataBase 에 저장된다.
<img src="https://user-images.githubusercontent.com/48972530/97726519-a2d28900-1b12-11eb-9e46-60ee71333ccc.png"  width="400" height="450"><img src="https://user-images.githubusercontent.com/48972530/97727580-ed083a00-1b13-11eb-8087-94f67bb82191.png"  width="400" height="450">
