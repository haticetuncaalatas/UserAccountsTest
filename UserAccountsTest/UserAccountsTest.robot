*** Settings ***
Documentation     These test cases created for testing User Accounts.
Library           RequestsLibrary
Library           Collections

*** Variables ***
${HOST}           http://localhost:8090
${id}             1
${name}           Generic Name
${phone}          999999999
${email}          genericname@company.com
${address}        Generic Street 42 Earth
${country}        Navarro
${department}     T21R
${message_type}    SUCCESSFUL

*** Test Cases ***
Scenario 1
    Given User can access the API
    When User fill the field id with "1"
    And User fill the field "name" with "Generic Name"
    And User fill the field "phone" with "999999999"
    And User fill the field "email" with "genericname@company.com"
    And User fill the field "address" with "Generic Street 42 Earth"
    And User fill the field "country" with "Navarro"
    And User fill the field "department" with "T21R"
    And User send this data to API (CREATE)
    Then API should return Ok Created with a success message

Scenario 2
    Given User can access the API
    When User fill the field id with "2"
    And User fill the field "name" with "Kuill"
    And User fill the field "phone" with "99999999999999"
    And User fill the field "email" with "genericname@company.com"
    And User fill the field "address" with "Generic Street 42 Hoth"
    And User fill the field "country" with "Arvala"
    And User fill the field "department" with "T21R"
    And User send this data to API (CREATE)
    Then API should return error with a message

Scenario 3
    Given User can access the API
    When User fill the field id with "1"
    And User fill the field "name" with "Generic Name"
    And User fill the field "phone" with "222222222"
    And User fill the field "email" with "genericname@company.com"
    And User fill the field "address" with "Generic Street 42 Earth"
    And User fill the field "country" with "Navarro"
    And User fill the field "department" with "T21R"
    And User send this data to API (UPDATE)
    Then API should return Ok with a success message

Scenario 4
    Given User can access the API
    When User wants to delete the account with id: "1"
    And User send this data to API (DELETE)
    Then API should return no content with a success message

*** Keywords ***
#### STEPS
Connect to WebService
    ${headers}    Create Dictionary    Content-Type=application/json
    Create Session    connectToAPI    ${HOST}    headers=${headers}    disable_warnings=True

Send add user id request
	[Arguments]    ${id}
    ${id}=	Set Variable	${id}

Send add user name request
    [Arguments]    ${name}
    ${name}=	Set Variable	${name}

Send add user phone request
    [Arguments]    ${phone}
    ${phone}=	Set Variable	${phone}

Send add user email request
    [Arguments]    ${email}
    ${email}=	Set Variable	${email}

Send add user address request
    [Arguments]    ${address}
    ${address}=	Set Variable	${address}

Send add user country request
    [Arguments]    ${country}
    ${country}=	Set Variable	${country}

Send add user department request
    [Arguments]    ${department}
    ${department}=	Set Variable	${department}

Send data to API CREATE
    ${body}    Create Dictionary    id=${id}    name=${name}    phone=${phone}    email=${email}    address=${address}    country=${country}    department=${department}
	${RESPONSE}    POST Request    connectToAPI    /users    json=${body}	
	${expected_status} =  Set Variable If  ${RESPONSE.status_code} == 200  Created  Error
	${message_type} =  Set Variable If  ${RESPONSE.status_code} == 200  Successfully created  User could not be created!
    Log    Returned Response: ${RESPONSE.text}
    Log    Response Status: ${RESPONSE.status_code} 

Send data to API UPDATE
    ${body}    Create Dictionary    id=${id}    name=${name}    phone=${phone}    email=${email}    address=${address}    country=${country}    department=${department}
    ${RESPONSE}    PUT Request    connectToAPI    /users/${id}    json=${body}	
	${expected_status} =  Set Variable If  ${RESPONSE.status_code} == 200  Updated  Error
	${message_type} =  Set Variable If  ${RESPONSE.status_code} == 200  Successfully updated  User could not be updated!
	Should Be Equal As Strings	200	${RESPONSE.status_code}
    Log    Returned Response: ${RESPONSE.text}
    Log    Response Status: ${RESPONSE.status_code}

Send data to API DELETE
    ${RESPONSE}    DELETE Request    connectToAPI    /users/${id}	
	${expected_status} =  Set Variable If  ${RESPONSE.status_code} == 200  Deleted  Error
	${message_type} =  Set Variable If  ${RESPONSE.status_code} == 200  Successfully deleted  User could not be deleted!
	Should Be Equal As Strings	200	${RESPONSE.status_code}
    Log    Returned Response: ${RESPONSE.text}
    Log    Response Status: ${RESPONSE.status_code}
	
Send delete user request
    [Arguments]    ${id}
    Log    user ${id} deleted

Return status code
    [Arguments]    ${expected_status}
    Log    status code:${expected_status}

Message Type
    [Arguments]    ${message_type}
    Log    Message type is:${message_type}

#### GIVEN
User can access the API
    Connect to WebService

#### WHEN
User fill the field id with "${id}"
    Send add user id request    ${id}

User fill the field "name" with "${name}"
    Send add user name request    ${name}

User fill the field "phone" with "${phone}"
    Send add user phone request    ${phone}

User fill the field "email" with "${email}"
    Send add user email request    ${email}

User fill the field "address" with "${address}"
    Send add user address request    ${address}

User fill the field "country" with "${country}"
    Send add user country request    ${country}

User fill the field "department" with "${department}"
    Send add user department request    ${department}

User wants to delete the account with id: "${id}"
    Send delete user request    ${id}

User send this data to API (CREATE)
    Send data to API CREATE

User send this data to API (UPDATE)
    Send data to API UPDATE

User send this data to API (DELETE)
    Send data to API DELETE

#### THEN
API should return ${expected_status} with ${message_type} message
    Return status code    ${expected_status}
    Message Type    ${message_type}
