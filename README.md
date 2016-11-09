# README #

###สิ่งที่ต้องเตรียมก่อนการเริ่มทำ Assignment###
* Java jdk 8
* Glassfish 4.1.1
* NetBeans IDE 8.1

###ประกอบด้วยโปรเจค Java web Application โดยโปรแกรม Netbean 2 โปรเจค###
* MovieClient
* MovieWebService

###ต้องแก้ไข path ใน MovieWebService ที่ source packages > serverpack > mvWebService.java###
* path สำหรับ path ที่บันทึกเป็น xml ใน function SaveXML
* xmlFile สำหรับ path ที่เป็นข้อมูลเริ่มต้น ใน function DeleteMovie, addMovie, movie(หน้า search), EditMovie, SaveMovie
* ถ้าต้องการให้บันทึกข้อมูลที่แก้ไขในไฟล์เริ่มต้น ให้ใช้ path เดียวกัน
* ทั้งสองตัวรับค่าจากตัวแปร url แก้ใน url

###อัพเดทเชื่อมต่อโปรเจคอ###
* เริ่มจาก Clean and Build before Deploy for MovieWebService
* ตามด้วย Clean and Build before Deploy for MovieClient
* จากนั้นที่ MovieClient > web service references > mvWebService > Refresh.. > check wsdl > yes
* Note: Clean and Build จะทำให้ได้ไฟล์ .war ใน directory dist in project 
* Note2: deploy จะทำให้สามารถเข้าถึงบริการจากจากเว็บได้

###หน้าบริการต่างๆในเว็บ MovieClient###
* Home.jsp   - หน้าแรก แสดงรายชื่อผู้จัดทำ
* Search.jsp - หน้าค้นหารายการภาพยนตร์ จาก ชื่อภาพยนตร์, ปีที่สร้าง, ประเภท, ระยะเวลาและผู้กำกับภาพยนตร์
* Add.jsp    - หน้าเพิ่มรายการภาพยนตร์
* Delete.jsp - หน้าลบภาพยนตร์จาก ID
* Edit.jsp   - หน้าแก้ไขภาพยนตร์จาก ID

###ส่วนของการตกแต่งหน้าเว็บที่ MovieClient###
* include folder css, images, js and file styles.css
* ที่หน้าเว็บจะมี Fragments ประกอบด้วยไฟล์โค้ดที่เป็นส่วนแสดงผลของหน้าบริการต่างๆ
