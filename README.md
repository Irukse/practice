## Practical assignment as part of the internship at the company Bell Integrator
#### Given: 

* organizations with offices and employees
* Directories with document types and country codes
#### REST архитектура:
All the described return data types are in the data parameter. 
Wherever the method is not written, use POST
 1. api/organization/list
In (filter):
{
  “name”:””, //required parameter
  “inn”:””,
  “isActive”:””
}
Out:
[
  {
    “id”:””,
    “name”:””,
    “isActive”:”true”
  },
  ...
]

2. api/organization/{id}
method:GET
Out:
{
  “id”:””,
  “name”:””,
  “fullName”:””,
  “inn”:””,
  “kpp”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}
3. api/organization/update
In: {
  “id”:””, //required parameter
  “name”:””, //required parameter
  “fullName”:””, //required parameter
  “inn”:””, //required parameter
  “kpp”:””,  //required parameter
  “address”:””, //required parameter
  “phone”,””,
  “isActive”:”true”
}

Out:
{
    “result”:”success”
}



4. api/organization/save
In: {
  “name”:””, //required parameter
  “fullName”:””, //required parameter
  “inn”:””, //required parameter
  “kpp”:””, //required parameter
  “address”:””, //required parameter
  “phone”,””,
  “isActive”:”true”
}

Out:
{
    “result”:”success”
}

5. api/office/list
In (filter):
{
  “orgId”:””, //required parameter
  “name”:””,
  “phone”:””,
  “isActive” 
}

Out:
[
  {
    “id”:””,
    “name”:””,
    “isActive”:”true”
  },
  ...
]

6. api/office/{id}
method:GET
Out:
{
  “id”:””,
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}
7. api/office/update
In:
{
  “id”:””, //required parameter
  “name”:””, //required parameter
  “address”:””, //required parameter
  “phone”,””,
  “isActive”:”true” //example
}

Out:
{
    “result”:”success”
}

8. api/office/save
In:
{
  “orgId”:””, //required parameter
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}

Out:
{
    “result”:”success”
}

9. api/user/list
In (filter):
{
  “officeId”:””, //required parameter
  “firstName”:””,
  “lastName”:””,
  “middleName”:””,
  “position”,””,
  “docCode”:””,
  “citizenshipCode”:””
}
Out:
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
}

10. api/user/{id}
method:GET
Out:
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipName”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true”
}

11. api/user/update
In:
{
  “id”:””, //required parameter
  “officeId”:””,
  “firstName”:””, //required parameter
  “secondName”:””,
  “middleName”:””,
  “position”:”” //required parameter
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true” //example
}

Out:
{
    “result”:”success”
}

12. api/user/save
In:
{
  “officeId”:””, //required parameter
  “firstName”:””, //required parameter
  “secondName”:””,
  “middleName”:””,
  “position”:”” //required parameter
  “phone”,””,
  “docCode”:””, code document 35 - passport?
  “docName”:””, Type_document 

  “docNumber”:””,employees number document.   Doc_employee

  “docDate”:””, Date on which employee documents were issued’.
   Doc_employee

  “citizenshipCode”:””, citizenship.  country
  “isIdentified”:”true” //example
}
handbooks:
api/docs
[
  {
    “name”:“Russian passport”,
    “code”:”21”
  },
  ...
]

Types of personal identification documents
api/countries
[
  {
    “name”:“Russian”,
    “code”:”643”
  },
  ...
]
