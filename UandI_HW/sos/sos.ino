#include<Wire.h>
#include<time.h>
#define C 262
#define D 294
#define E 330

int buttonPin = 8; //pin 번호 8에 + 와 GND 연결
//time_t now = time(NULL);
int tempo = 200; // duration 옵션 값을 설정
int notes[13] = { E,D,C,D,E,E,E,D,D,D,E,E,E }; //동요 종이비행기
void setup() {
  // put your setup code here, to run once:
  Wire.begin();
  Serial.begin(9600);
  pinMode(buttonPin, INPUT_PULLUP); // 스위치를 구성하기 쉬운 방법 INPUT_PULLUP
}

void loop() {
  // put your main code here, to run repeatedly:
  if(digitalRead(buttonPin)==LOW){
    // 스위치가 눌렸을 때, 떼어졌을 때 무슨 숫자가 나올지 찍어봄
    // Serial.println(digitalRead(buttonPin));
    Serial.println("SOS Buton pressed");
    playmusic();
    delay(500);
    }
}
void playmusic(){
  for(int i = 0; i< 13; i++){
    tone(13,notes[i],tempo);
    delay(250);
    }
  }
