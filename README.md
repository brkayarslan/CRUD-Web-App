# Enoca Chalange



## 1- MVC kavramını açıklar mısınız ? Neden ihtiyaç duyuluyor. Java’da nasıl kurgulanıyor. Object Oriented katmanları nelerdir ?

MVC, Model-View-Controller (Model-Görünüm-Kontrolör) kavramının kısaltmasıdır. Bu kavram, 
yazılım tasarımında sıkça kullanılan bir mimari desendir. MVC mimarisinde, bir uygulamanın temel bileşenleri
Model, View ve Controller olarak ayrılır ve her biri farklı bir sorumluluğa sahiptir.

Model: Uygulamanın veri ve işlem mantığını içerir. Veritabanı, dosya okuma/yazma işlemleri gibi işlemler 
Model katmanında gerçekleştirilir.

View: Uygulamanın arayüzünü oluşturur. Kullanıcıların gördüğü sayfalar ve kullanıcı arayüzü View katmanında 
tasarlanır.

Controller: Model ve View arasında iletişimi sağlar. Kullanıcıların yaptığı istekler Controller katmanında işlenir 
ve uygun Model verileri View katmanına gönderilir.
Java'da MVC tasarım deseni, genellikle Servletler ve JSP'lerle birlikte kullanılır. Servletler, Controller katmanını, JSP'ler ise
View katmanını oluştururlar. Model katmanı ise veritabanı işlemlerini gerçekleştirmek için JDBC veya ORM 
araçlarıyla yapılandırılabilir.

Presentation Layer – yazılım sistemi ile kullanıcı etkileşimlerinden sorumlu katman
Application Layer – fonksiyonel gereksinimlerin yerine getirilmesiyle ilgili katman
Domain Layer – algoritmalardan ve programlama bileşenlerinden sorumlu katman
Database Layer – veri işleme, veritabanlarından sorumlu katman

## 2-Birbirinden bağımsız iki platformun birbiriyle haberleşmesi nasıl sağlanabilir. Örneğin, X platformu Java ile yazılmış olsun, Y platform u C# ile. Bu iki platformun bir biri ile iletişim halinde request-response ilişkisi kurması gerekiyor. Bu yapıyı nasıl sağlarız.

API'ler ile sağanabilir.API'ler, iki yazılım bileşeninin belirli tanımlar ve protokoller aracılığıyla birbiriyle
iletişim kurmasına olanak tanıyan mekanizmalardır. SOAP ve RESTful web servisleri olmak üzere iki farklı türü 
vardır. SOAP, XML tabanlı bir protokol kullanırken, RESTful, HTTP protokolüne dayanarak JSON veya XML formatlarını kullanır.
RESTful web servisleri, bir URI kullanarak kaynaklara erişir. Bu kaynaklar, HTTP protokolü 
üzerinden GET, POST, PUT, DELETE vb. HTTP yöntemleri kullanılarak sağlanır. Bu nedenle, X platformundaki Java 
uygulaması, Y platformundaki C# uygulamasının URI'sini kullanarak kaynaklara erişebilir.

## 3-Bir web sayfasında ekran sürekli Backend’ den veya bir başka yapı tarafından güncelleniyor. Siz, web sayfasını refresh etmeden bu güncel bilgiyi anlık ekrana nasıl yansıtırsınız.

Bu durumda, web sayfasındaki içeriği dinamik olarak güncellemek için "WebSocket" teknolojisi kullanılabilir. 
WebSocket, web sayfası ile sunucu arasında çift yönlü iletişim sağlayan bir protokoldür. Bu protokol kullanılarak, sunucudan 
gelen veriler anlık olarak web sayfasına gönderilebilir ve sayfada görüntülenebilir.

WebSocket, bir HTTP bağlantısı kullanarak başlatılır ve daha sonra tam çift yönlü bir iletişim kanalına yükseltilir. Bu iletişim 
kanalı, sunucudan gelen verileri anlık olarak web sayfasına iletebilir. Web sayfası da bu verileri, JavaScript kullanarak anlık 
olarak sayfada güncelleyebilir.

## 4-Bir for döngüsü ile aşağıdaki çıktıyı yazar mısınız.

| *            
| **         
| ****       
| ******          
| ********       
| **********

'''java

   int j = 0;   
   for(int i = 0; i<=5;i++){
       j=0;
       do{ 
            System.out.print("*");
            j++;
            }while( j<i*2);
            System.out.println();
        }
'''
## 5- Firmada çalışman için sana remote bir linux server verildi. Elinde ip adresi port bilgisi kullanıcı adi ve şifren var. Server a erişimi nasıl test edersin, Server a nasıl erişirsin, Server a nasıl dosya atarsın, Serverdan nasıl dosya çekersin.

Server'a erişim testi yapmak için, öncelikle terminal üzerinde aşağıdaki komutu kullanarak server'a ssh bağlantısı kurarım:
ssh kullaniciadi@ipadresi -p portnumarasi

Ardından serverı test etmek için serverda çalışan işlem listesini görmek için aşağıdaki komutu kullanırım:
ps -ef

Localimden server'a  dosya atmak için 'scp' komutunu kullanırım. Aşağıdaki komut bunun bir örneğidir.
scp   /path/to/local/file/ornek_dosya.txt    kullaniciadi@ipadresi:/path/to/remote/directory

Serverdan localime bir dosya çekmek istersem yine 'scp' komutunu kullanırım. Aşağıdaki komut bunun bir örneğidir.
scp   kullaniciadi@ipadresi:/path/to/remote/file/ornek_dosya.txt      /path/to/local/directory

## 6-Local database kurulumu (mysql, postgresql veya herhangi bir database) 
- Java spring uygulaması ayağa kaldırılması,
- İki adet tablo yer alamalı ve bu tabloların birbirleriyle bağı olmalıdır. (Örn: şirket ve çalışan
gibi),
- Java spring uygulamasında ekleme,silme,güncelleme,listeleme gibi servisler yer almalıdır ve
responseda yapılan işlem detayı return edilmelidir.
- Ekleme,silme,güncelleme,listeleme işlemlerini postman vb ile işlem yapılabilmelidir.

Bu adımlar sırasıyla izlenip java uygulaması üzerinden database’ e kayıt atılmalı (Herhangi
bir kayıt olabilir fark etmez. Database'de bir tablo açılıp o tabloya değer girilmesi java isteği
üzerinden). Daha sonra aynı istek atılan uygulama ile (örnek postman ...) get ve list java
spring endpointleri çağırılarak, database e atılan kayıt response olarak dönülmeli.

MVC deki model ve kontroller akışının güzel kurgulanması ve uygulama ayağı nasıl
kaldırılıp servislerin nasıl kullanıldığına dair bir döküman hazırlanmalıdır. Bu proje için
kaynak kodu ile iletilmesi gerekmektedir.

## 7-Apache Solr servisine yazılacak bir query örneği Apache Solr kullanılan sql programlarından daha farklı runtime bir database. Solr a hali hazırda kayıtlı bir alan olduğunu düşünelim. Alanın ismi “updatedAt” long tipinde tutulan bir alan. Ben 2020 Ocak ayından sonraki verileri getir dediğimde solr a nasıl bir query yazılmalı. http://example?query= kısmını nasıl doldurmalıyım?

Solr, bir arama motoru olduğu için, sorguları "arama sorguları" olarak yazmanız gerekir. Verileri bir SQL veritabanındaki gibi sorgulamak yerine, 
Solr'un dizininde indekslenmiş belgeleri arayarak sonuçlar elde edersiniz.

http://example.com/solr/collection/select?q=updatedAt:[2020-01-01T00:00:00Z TO *]
