# This project gives brief introduction about using GraphQL with Spring-Boot

## Versions of components used:

spring-boot.version: 2.0.4.RELEASE
graphql-spring-boot.version: 5.0.2
graphql-java-tools.version: 4.3.0

 
## Steps to setup this project:

1. Clone using following command:
git clone 

2. Import this project into an IDE (I used eclipse)

3. Build project:
mvn clean install

4. Run class: com.poc.springboot.SpringBootApplicationStarter



## URL for Voyager

http://localhost:8090/voyager


## URL for graphiql

http://localhost:8090/graphiql


##Introduction

### Phone -> No input parameter from user. Returns single object of type 'PhoneDO'.
### Request:
{ phone {
    phoneNumber
    isValid
    phoneNumberType
}
}

### Response:
{
  "data": {
    "phone": {
      "phoneNumber": "9891",
      "isValid": true,
      "phoneNumberType": "home"
    }
  }
}

### Phones -> No input parameter from user. Returns object of type 'PhonesDO', which contains list of 'PhoneDO'.
### Request:
{ phones {
    phoneNumber
    isValid
    phoneNumberType
}
}

### Response:
{
  "data": {
    "phones": [
      {
        "phoneNumber": "phone1",
        "isValid": true,
        "phoneNumberType": "home"
      },
      {
        "phoneNumber": "phone2",
        "isValid": true,
        "phoneNumberType": "mobile"
      }
    ]
  }
}

### Email -> This takes input parameters from user. Returns single object of type 'EmailDO'.


# Steps to be followed to create a project from scratch

## 1. Create new sprint-boot project in an IDE
## 2. Add support for GraphQL
## 3. Write java model/pojo classes
## 4. Create GraphQL schema file
## 5. Write resolver bean
 

