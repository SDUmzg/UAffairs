# University Affairs Management System #
## The Main Function ##
1. **Login And Register**
	JWT、Shiro、2FA
2. **Class information management**
	class number manage? choose item and export to a excel? 
3. **Grading**
	school? -> college? -> class?
4. **Manage class address book**
	data permissions?
5. **Notification system**
	binding weichat
6. **Questionnaire system**
7. **Note of absence**
8. **Feedback,suggest,complaints**
9. **Form establishment and consolidation**
	a excel model file to special people, after consoliudation , export a excel .
10. **Email system ? consider no**
11. **Payment**
	membership fee,party membership dues,league membership dues
12. **Late rollcall**
13. **Homework system**
	distribution and submit
	
### 各模块对应的服务名与端口号
| File Name                 | Service Name     |  Port     |
| --------                  | --------         | --------  |
| uaffairs-server-discovery |                  |   8100    |
| uaffairs-config-center    | config-server    |   8110    |
| uaffairs-hbase-client     | hbase-client     |   8120    |
| uaffairs-common-service   | common-service   |   8130    |
| uaffairs-router-gateway   | service-zuul     |   8140    |
| uaffairs-febs-client      | febs-client      |   8150    |
| uaffairs-xxlsso-server    | xxlsso-server    |   8160    |
| uaffairs-web-client       | xxlsso-web       |   8170    |
| uaffairs-dynamic-datasources| dynamic-datasources | 8180 |

