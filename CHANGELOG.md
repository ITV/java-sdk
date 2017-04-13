> **LoginRadius Java SDK Change Log** provides information regarding what has changed, more specifically what changes, improvements and bug fix has been made to the SDK. For more details please refer to the [LoginRadius API Documention](https://docs.loginradius.com/api/v2/sdk-libraries/java-library)



### Version 3.0.0
Released on **April 13,  2017**


##### Enhancements

  - Added new multiple APIs for better user experience.
  - EndUser add and remove multiple Emails.
  - Added update profile feature in SDK.
  - Significantly improved code performance.
  - Reduce number of library from SDK.
  - Added phonenuber and username login.
  - By default the connection timeout (the time it takes to connect to a server) is 10000, and the socket timeout (the time it takes to receive data) is 60000. 
  

### Version 2.5.3
Released on **January 12,  2017**

##### Enhancements
  - Significantly improved code performance.

##### Bug Fixes
  - Updated SDK to Fetch Custom Fields.
 
 

### Version 2.5.1
Released on **June 20,  2016**

##### Enhancements

  - Custom object APIs have been newly added
  - Wrapper methods for latest LoginRadius APIs have been added in Account API and User API
  - Significantly improved code performance.
 
##### API breaking changes

  - This is a revamp of the previous SDK. Most of the classes are re-written for providing ease of implementation and to cover all of the existing 
  - There are breaking changes in user-create/user-register and user-update apis

##### Bug Fixes

  - User create/update and User register can now be used to update custom fields
  - Issue with the method UserEmailAvailabilty is fixed and the method returns isExist=true
  - Issue with Token validate and invalidate methods is fixed and these methods return expected results.
 

