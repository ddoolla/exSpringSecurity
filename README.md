# Spring Security

> ## 환경설정

### * src/main/resources/application.properties
```
spring.application.name=securitydemo

#datasources
spring.datasource.driver-class-name=드라이버
spring.datasource.url=DB주소
spring.datasource.username=아이디
spring.datasource.password=비밀번호

#jpa
spring.jpa.open-in-view=false

#hibernate
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
#logging.level.org.hibernate.type.descriptor.sql=trace

#spring.jpa.properties.hibernate.use_sql_comments=true
```

<br/>

---
