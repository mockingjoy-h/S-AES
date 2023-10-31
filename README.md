S-AES算法实现 测试结果
=
重庆大学大数据与软件学院信息安全导论实验S-AES算法的实现，在胡海波老师的指导下，由刘雨航和韩奕牛共同完成。
  
编程与测试要求
-
1.第1关：基本测试  
根据S-AES算法编写和调试程序，提供GUI解密支持用户交互。输入可以是16bit的数据和16bit的密钥，输出是16bit的密文。  
  
2.第2关：交叉测试  
考虑到是"算法标准"，所有人在编写程序的时候需要使用相同算法流程和转换单元(替换盒、列混淆矩阵等)，以保证算法和程序在异构的系统或平台上都可以正常运行。  
设有A和B两组位同学(选择相同的密钥K)；则A、B组同学编写的程序对明文P进行加密得到相同的密文C；或者B组同学接收到A组程序加密的密文C，使用B组程序进行解密可得到与A相同的P。  
  
3.第3关：扩展功能  
考虑到向实用性扩展，加密算法的数据输入可以是ASII编码字符串(分组为2 Bytes)，对应地输出也可以是ACII字符串(很可能是乱码)。  
  
4.第4关：多重加密  
4.1 双重加密将S-AES算法通过双重加密进行扩展，分组长度仍然是16 bits，但密钥长度为32 bits。  
4.2 中间相遇攻击假设你找到了使用相同密钥的明、密文对(一个或多个)，请尝试使用中间相遇攻击的方法找到正确的密钥Key(K1+K2)。  
4.3 三重加密将S-AES算法通过三重加密进行扩展，下面两种模式选择一种完成：(1)按照32 bits密钥Key(K1+K2)的模式进行三重加密解密，(2)使用48bits(K1+K2+K3)的模式进行三重加解密。  
  
5.第5关：工作模式  
基于S-AES算法，使用密码分组链(CBC)模式对较长的明文消息进行加密。注意初始向量(16 bits) 的生成，并需要加解密双方共享。在CBC模式下进行加密，并尝试对密文分组进行替换或修改，然后进行解密，请对比篡改密文前后的解密结果。
  
第1关：基本测试
-
运行SAESUI.java，如下图，选择二进制单重加密，输入16bit的明文1111111111111111和16bit的密钥1111111111111111，得到16bit的密文0101001101000011：  
  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/4c2088a1-e6b5-4b30-9895-10e62e027016">  
  
  
第2关：交叉测试 
-
运行SAESUI.java，如下图，进行解密得到正确的明文：  
  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/f7cd3ca5-29cd-44a5-ab32-5e3c38038919">  
  
同时，我们的结果与朱清杨、黄亦康等组都完成了交叉测试，没有问题。  
  
第3关：扩展功能
-
运行SAESUI.java，如下图，选择字符串单重加密，输入字符串明文abcacb，密钥1111111111111111，得到以下密文：  
  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/95e8b35d-d855-45ea-83d0-e86f5b5b6143">  
  
进行解密，结果如下，答案正确：  
  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/0a9a06f5-677d-4b06-a4a1-75cd14a4d449">  
  
  
第4关：多重加密
-
1.双重加密将S-AES算法通过双重加密进行扩展，分组长度仍然是16 bits，但密钥长度为32 bits。  
运行SAESUI.java，如下图，我们输入明文0101110001100100，密钥01010101010101010101010101010101，得到以下密文： 
  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/81303084-4878-4859-a050-97de18f857d9">  
  
解密得到以下结果，结果正确：  
  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/15d510dd-1c1d-4b38-9b32-38b7a4f674b7">  
  
  
2.中间相遇攻击假设你找到了使用相同密钥的明、密文对(一个或多个)，请尝试使用中间相遇攻击的方法找到正确的密钥Key(K1+K2)。  
运行AttackInMiddle.java，如下图，输入明文0011010100110101，输入密文0101010101010101： 
  
<img width="250" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/b1aea20e-fce9-49c8-8f55-4a99abde69d6">  
  
得到破解结果和破解时间：  
  
<img width="350" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/7ca56be1-9694-47cc-af03-9d31ea29b3f7">  
  
3.三重加密将S-AES算法通过三重加密进行扩展，使用48bits(K1+K2+K3)的模式进行三重加解密。  
运行SAESUI.java，如下图，选择二进制三重加密，输入明文0110111101101011，密钥101001110011101110100111011111110101010111000101，加密得到以下密文：  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/87ff77b2-cec4-4e4d-8c4a-710bd4cfedd3">  
解密，得到以下结果，结果正确：  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/197e9a68-0a3f-46ca-9b8e-1b1c5d2e724f">  
  
第5关：工作模式
-
运行CBCUI.java，如下图，输入明文111100001010101011001100110011111111000000001010，密钥0101010101010101，进行CBC加密，得到以下密文：  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/93467936-1a82-44af-99f3-d5c3438bd710">  
进行CBC解密，结果正确：  
<img width="500" alt="image" src="https://github.com/mockingjoy-h/S-AES/assets/147220129/95d7dd8b-7269-49d2-854f-202e22d12f25">



