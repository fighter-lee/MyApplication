# 第一章  计算机及信息技术概述
1.	电子计算机的发展历程
①1946年2月由宾夕法尼亚大学研制成功的ENIAC是世界上第一台电子数字计算机。“诞生了一个电子的大脑” 致命缺陷：没有存储程序。  
②电子技术的发展促进了电子计算机的更新换代：电子管、晶体管、集成电路、大规模及超大规模集成电路  
电子计算机发展时间：  
	第一代 1946-1958 电子管计算机，主要应用科学计算和军事计算   
	第二代 1958-1964 晶体管计算机，主要应用于数据处理领域  
	第三代 1964-1971 集成电路计算机，主要应用于可科学计算，数据处理，工业控制等领域  
	第四代 1971年以来 超大规模集成电路，深入到各行各业，家庭和个人开始使用计算机  
2.	计算机的类型  
按计算机用途分类：通用计算机和专用计算机  
按计算机规模分类：巨型机、大型机、小型机、微型机、工作站、服务器、嵌入式计算机  
按计算机处理的数据分类：数字计算机、模拟计算机、数字模拟混合计算机   
3.	计算机的特点及应用领域  
计算机是一种能按照事先存储的程序，自动、高速地进行大量数值计算和各种信息处理的现代化智能电子设备。（含义）  
A.	运算速度快   运算速度用MIPS(百万条指令每秒)来衡量，是计算机性能的指标之一  
B.	计算精度高   应用于数值计算  
C.	具有逻辑判断能力 信息检索、图形识别  
D.	记忆性强  
E.	可靠性高、通用性强 应用于数据处理、工业控制、辅助设计（CAD）、辅助制造（CAM）办公自动化。   
应用领域：1）数值计算 （主要是科学研究等数学计算问题）  
          2）数据及事务处理 （非科技方面的数据管理和计算处理）  
          3）自动控制与人工智能 （多用于航空航天领域）  
          4）计算机辅助设计（CAD）、计算机辅助制造（CAM）、计算机辅助教学（CAI）  
          5）通信与网络  
4.	计算机发展趋势：巨型化、微型化、网络化、智能化  
1、光计算机     2、生物计算机      3、量子计算机  
5.	常用的数制  
进位制	进位规则	基数	所用的数码	位   权	 表示符号  
二进制	逢二进一	R=2	O,1	2i	B（Binary）  
八进制	逢八进一	R=8	0,1,…,7	8i	O（Octal）  
十进制	逢十进一	R=10	0,1,…,9	10i	D(Decimal)  
十六进制	逢十六进一	R=16	0,1…,9,A,.F	16i	H(Hexadecimal)  
基数：R进制的基数=R  
位权：在数制中，各位数字所表示值的大小不仅与该数字本身的大小有关，还与该数字所在的位置有关，我们称这关系为数的位权。  
位权：一个与数字位置有关的常数，位权=Rn  

6.	数据、信息和信息编码的概念
数据不仅指数字、字母、文字和其他特殊字符。而且还包括图形、图像、动画、影像、声音等多媒体数据。  
信息是人们按照预先的目的，通过从各种不同的渠道、不同的角度观察记录反映客观事物状态和特征的某种概念或经过加工后的数据。  
信息强调的是对人有用的数据，这些数据将可能影响到人们的行为与决策。数据是客观存在的事实、概念等，是一种可供加工的特殊表达形式。  
信息编码的基本元素是0和1两个数码，称为二进制。  
7.	计算机仍采用二进制位数表示信息的原因：
1）物理上容易实现  2）运算规则简单 3）可靠性高 4）易于实现逻辑运算和逻辑判断  
8.	二进制和其它进制的转换
十进制转二进制：整数部分除以2取余，直至商为0；小数部分乘以2取整，直至小数部分为0或达到所需精度为止。  
      十进制转八进制：方法同上。整数部分除以8，小数部分乘以8。  
      十进制转十六进制：方法同上。整数部分除以16，小数部分乘以16。   
9.	计算机中的数据单位
位(bit)：计算机存储数据的最小单元(0、1)  
字节(Byte)：处理数据的基本单位(8bit/Byte)  
常用的字节计数单位：  
         1KB＝1024 Byte  (210B)        1MB＝1024 KB  (220B)  
         1GB＝1024 MB    (230B)        1TB＝1024 GB   (240B)  
字长：CPU一次处理数据的二进制位数。  
10.	信息表示与编码
所谓编码，就是利用数字串来标识所处理对象的不同个体。  
	在数学中，数值是用“＋”和“－”表示正数和负数的，而在计算机中只有0和1，所以正负号也用0和1表示，即数值符号数字化。  
	“模”是指一个系统所能表示的数据个数。按模运算是指运算结果超过模时，模（或模的整数倍）将溢出而只剩下余数。   
       假设M为模，若数a，b满足a＋b＝M，则称a，b互为补数。  
       在有模运算中，减去一个数等于加上这个数对模的补数。   
	原码 用0表示正号 1表示负号 例如：（+45）10的原码为（00101101）2  ，（-45）的原码为（10101101）2  
	反码 对于正数，其反码与其原码相同；对于负数，用相应正数的原码各位取反来表示，包括将符号位取反。  
	补码 正数的补码与原码和反码相同；负数的补码为该负数的反码末位加1.  
11.	实数的表示
定点数：小数点位置固定的数称为定点数。
浮点数：小数点位置不固定的数称为浮点数
	BCD码 即用二进制位表示十进制，最常见的是842BCD码采用四位二进制表示一位十进制。  
	ASCII码 采用7位二进制表示一个字符，一个字节占8位二进制，一个ASSII码占最低7位，最高位通常定位0.可以有27中状态，即128种状态。  
	汉字编码输入码  
a)	输入码  
b)	国标码和区位码：每个汉字占两个字节的编码，且每个字节最高位均为0。所有汉字分94个区，每个区94个汉字。由此构成区位码。而区位码的区码和位码各加32就得到国标码。  
c)	机内码  
d)	字型码：汉字存储在计算机内采用机内码，但输出时必须转换成字形码，再根据字形码输出汉字。字形码又称汉字字模，用于在显示器或打印机上输出各种文字和符号。  
点阵汉字：每一个汉字以点阵形式存储，有点的地方为“1”，空白的地方为“0”。有16×16、24×24、48×48点阵等。点阵越大，字形分辨率越好，字形也越美观，但汉字存储的字节数就多，字库也就越庞大。  

# 第二章  计算机系统
1.	计算机系统的构成
一个完整的计算机系统是由硬件和软件组成。  
硬件是由运算器、控制器、存储器、输入设备、输出设备五部分组成。其中：  
         中央处理器(简称CPU)=运算器+控制器  
         主机=中央处理器+主存储器  
软件是指各类程序和数据，计算机软件包括计算机本身运行所需要的系统软件和用户完成任务所需要的应用软件。  

2.	冯·诺依曼型计算机的结构 
冯·诺依曼型计算机是将程序和数据事先存放在外存储器中，在执行时将程序和数据先从外存装入内存中，然后使计算机在工作时自动地从内存中取出指令并加以执行，这就是存储程序概念的基本原理。  
冯·诺依曼计算机体系结构的主要特点是：  
(1) 采用二进制形式表示程序和数据。   
(2) 计算机硬件是由运算器、控制器、存储器、输入设备和输出设备五大部分组成 。  
(3) 程序和数据以二进制形式存放在存储器中。   
(4) 控制器根据存放在存储器中的指令 (程序) 工作。  

3.	中央处理器 CPU
CPU：运算器部件、寄存器部件和控制器部件。  
CPU从存储器取出指令，放入CPU内部的指令寄存器，并对指令译码。它把指令分解成一系列的微操作，然后发出各种控制命令，执行微操作系列，从而完成一条指令的执行。  
CPU的主要性能指标 ：  
(1) 主频/外频（主频=外频×倍频，即CPU工作频率）  
(2) 数据总线宽度（即字长，指CPU传输数据的位数）  
(3) 地址总线宽度（决定了CPU可访问的地址空间）  
(4) 工作电压（低电压可减少CPU过热，降低功耗）  
(5) 高速缓存Cache（加速CPU与其它设备间数据交换）  
(6) 运算速度（CPU每秒能处理的指令数）  
	运算器   
运算器是完成算术和逻辑运算的部件，又称算术和逻辑运算单元。计算机所完成的全部运算都是在运算器中进行的。运算器的核心部件是:  
       (1) 运算逻辑部件   
       (2) 寄存器部件  
	控制器  
        控制器负责从存储器中取出指令，并对指令进行译码，并根据指令译码的结果，按指令先后顺序，负责向其它各部件发出控制信号，保证各部件协调一致地完成各种操作。  
控制器主要由以下部件组成：  
        ① 程序计数器。存放下一条将要执行的指令在内存中的地址；  
        ② 指令寄存器。保存现在正在执行的指令；  
        ③ 指令译码器。用来识别指令的功能，分析指令的操作要求；  
        ④ 时序部件。产生计算机工作中所需的各种定时控制信号，对各种微操作控制信号进行定时控制。以协调各部件的工作顺序；  
        ⑤ 微操作控制电路。一条指令的执行可以分解为一系列不可再分的微操作命令信号，即微命令，以指挥整个计算机有条不紊地工作。  
        
4.	主板 
主板是电脑中各种设备的连接载体。它提供CPU、各种接口卡、内存条和硬盘、软驱、光驱的插槽，其它的外部设备也会通过主板上的I/O接口连接到计算机上。早期的PC机主板是将快速的CPU、中速的内存、慢速的外设都连接在一条总线上，使系统的总体性能得不到优化。

5.	主存储器 
主存储器，简称主存，也叫内存储器 (简称内存)，由半导体材料构成。内存分为只读存储器和随机读写存储器。   
	只读存储器ROM   
•	特点：存储的信息只能读出，不能随机改写或存入，断电后信息不会丢失，可靠性高。  
•	ROM分类  
   (1) 掩膜式 ROM(Mask ROM)  
   (2) 可编程 PROM(Programmable ROM)  
   (3) 可擦除 EPROM (Erasable PROM)  
   (4) 电可擦 EEPROM(Electrically EPROM)  
   (5) 快擦写 ROM(Flash ROM)  
	随机存储器RAM  
        特点：用于存放原始数据、中间结果、最终结果。开机前是空的，断电后数据消失。  
        RAM 分类:   
	SRAM：静态RAM。不需要充电来保持数据完整性，成本高且集成低，一般做高速缓冲存储器。  
       (2) DRAM：动态RAM。需要定时充电来保持数据的完整性，通常所说的“内存”主要由它构成。一般指以下两种类型：  
       ① SDRAM---同步动态存储器     
       ② DDR---双倍速率内存  
            (DDR2---四倍速率内存\DDR3)  
	Cache(高速缓存 )  
        Cache是一种高速缓冲存储器，是为了解决CPU与主存之间速度不匹配而采用的一种重要技术。其中片内Cache是集成在CPU芯片中，片外Cache是安插在主板上。高速缓冲存储器的存取速度比主存要快一个数量级，大体与CPU的处理速度相当。   
	多级缓存   
        最早的CPU缓存容量很低。当集成在CPU内核中的缓存已不能满足CPU的需求，而制造工艺上的限制又不能大幅度提高缓存的容量时，出现了集成在与CPU同一块主板上的缓存，此时把CPU内核集成的缓存称为一级缓存，而外部的称为二级缓存。  
        现在多数CPU内部也有二级缓存，于是二级缓存又可分为内部二级缓存和外部二级缓存。较高端的CPU中还会带有三级缓存 。  
 
6.	总线
总线：是一组连接各个部件的公共通信线路，是计算机内部传输指令、数据和各种控制信息的高速通道，是计算机硬件的一个重要组成部分。
① 地址总线。传输的是地址信号，一般是单向传输。当CPU需要访问某个外设时，它向地址总线发出相应外设的地址信号，以选择某个外设。
② 数据总线。传输的是数据，一般是双向传输。CPU进行“读”时，数据由外设流向CPU，当CPU进行“写”时，数据由CPU流向外设。
③ 控制总线。有的是CPU向内存或外部设备发出的信号；有的是内存或外部设备向CPU发出的信号。对每条控制线而言信号是单向传送，但作为整体是双向的。
系统总线标准大致可分为ISA总线、PCI总线、PCI Express三个阶段。
① ISA总线。是最早的8位系统总线。后来扩展到16位。ISA是现代个人计算机的基础。
② PCI总线。主要特点是传输速度高，广泛应用于现代微机中。
③ AGP总线。专为系统中一块图形显示卡设计的总线。
④ PCI Express总线。是新一代的总线接口。
7.	接口
       I/O接口是连接主机和外部设备之间的逻辑部件，由I/O接口电路、连接器(一般为连接电缆)和接口软件(即设备驱动程序)组成。
         根据I/O接口是否内嵌在主板中，可将I/O接口分为内置I/O接口和外置I/O接口两类。
(1) 内置I/O接口
        将I/O接口电路内嵌在主板中，由主板提供外设接口电路插座，如键盘接口、鼠标接口、USB接口、串口、并口及软硬盘接口等。 
(2) 外置I/O接口
     将I/O接口集成到一块独立的电路板(接口卡)上，接口卡必须插在总线扩展插槽上(如PCI、PCI Express插槽等) 。
8.	输入/输出子系统 简称外设
 	非存储设备 常见的非存储设备有；键盘、鼠标和显示器、打印机。
 	存储设备 也叫外存。存储设备通常分为磁介质、光介质、半导体介质。
1)	磁介质  磁介质存储设备使用磁性来存储数据位。最常见的磁介质存储设备是磁盘和磁带。软盘、硬盘都是属于磁介质的存储设备。软盘因为在读写速度、存储稳定性、存储容量上不能满足用户的需要而几乎被淘汰了。
2)	光介质 光存储设备是使用激光技术来存储和读写数据。CD-ROM/CD-R/DVD
3)	半导体存储设备 半导体设备普通采用一种叫做“Flash Memory”的技术，即闪存技术。主要代表物是U盘
9.	光盘存储器
        光盘简称CD(Compact Disc)是利用塑料盘片表面凹凸不平的特征，通过光的反射来记录和识别二进制的0、1信息。
光盘的分类: 
	只读型光盘
        只读光盘中的数据是在制作时写入的，用户只能读数据，而不能写入或修改光盘中的数据。音频光盘CD-DA、数据光盘 CD-ROM、 VCD、DVD等都属于只读光盘。 
	一次写入光盘
        这种光盘允许一次写入数据，但不能修改和擦除数据， 如 CD-R。
	可擦写光盘
        这种光盘可多次写入或修改数据，如CD-RW。
10.	硬盘
 硬盘是微机最重要的外部存储器，常用于安装微机运行所需的系统软件和应用软件，以及存储大量数据。
	硬盘存储格式
        硬盘是由多个涂有磁性物质的金属圆盘盘片组成，盘片的每一面都有一个读写磁头，在对硬盘进行格式化时，将对盘片进行划分磁道和扇区，对于大容量的硬盘还将多个扇区组织起来成为一个块——“簇”，簇成为磁盘读写的基本单位。有的簇是一个扇区，有的有好几个扇区，可以在格式化的参数中给定。
	硬盘性能指标
         ① 硬盘的容量。现在微机上所配置的硬盘一般在200GB以上。
         ② 硬盘的转速。硬盘的转速越快，硬盘寻找文件的速度也就越快。现在的主流硬盘转速一般为7200rpm以上。
         ③ 缓存。硬盘自带的缓存，缓存越多，越能提高硬盘的访问速度。 
	硬盘接口
         硬盘接口分为IDE、SATA、SCSI和光纤通道四种，IDE接口硬盘多用于家用产品中，SATA是种新生的硬盘接口类型。
	硬盘格式化
        ① 硬盘低级格式化。主要是对一个新硬盘划分磁道和扇区。
        ② 硬盘分区。把硬盘划分为成若干个相对独立的逻辑分区 。
        ③ 硬盘高级格式化。高级格式化主要是对指定的硬盘分区进行初始化，建立文件分配表以便系统按指定格式存储文件。。
11.	打印机
        常用的有针式打印机、喷墨打印机和激光打印机等。 
        ① 针式打印机特点。利用钢针击打色带把色带上的墨打印在纸上形成文本或图形。缺点是打印质量差、速度慢、噪声大；优点是可以打多联纸，耗材相对较便宜。
        ② 喷墨打印机特点。打印头上有若干个喷头，打印时，墨水以每秒近万次的频率喷射到纸上。与其它两类打印机相比，在打印质量、速度、噪声及成本方面处于中等层次。
        ③ 激光打印机特点。利用激光可以形成很细的光点，将碳粉固着在纸上，加热后碳粉固定在纸上，最后印出文字和图片。优点是打印速度快、噪音低、质量好，缺点是价格及打印成本较高。
       对三种打印机的打印效果对比来说，激光最好，喷墨其次，而针式相对较差。 
12.	计算机指令系统 
       指令：是指计算机执行特定操作的命令。是程序设计的最小语言单位。
       指令构成：操作码+地址码（操作码和操作数）
       指令系统：是指一台计算机所能执行的全部指令的集合。不同型号的计算机有不同的指令系统。它反映了计算机的处理能力。
可分为以下四个步骤：
        开始执行程序时，先给程序计数器PC赋以第一条指令的首地址0100H。
        ①取指令  按照计数器中的地址从内存中取出指令(070270H)，并送往指令寄存器。然后计数器PC自动加1指向下一指令地址。
②分析指令  对指令寄存器中存放的指令(070270H)进行分析，由译码器对操作码 (07H)进行译码，由地址码(0270H)确定操作数地址。
③执行指令 取出操作数，去完成该指令所要求的操作。例如做加法指令，取内存单元(0270H)的值和累加器的值相加，结果还是放在累加器。
④一条指令执行完成，再回到①取指令阶段开始下一指令的执行。
13.	计算机硬件系统的性能指标 
        (1) CPU的主频。主频越高，单位时间内完成的指令数也越多，CPU工作的速度也就越快。 
       (2) 字长。字长越长，计算机一次所能处理信息的位数就越多，表现为计算机的运算速度越快。 
       (3) 运算速度。它是一项综合性的性能指标。是指计算机每秒钟执行的指令数，单位是MIPS，即每秒百万条指令。
       (4) 内存容量。内存容量越大，一次读入的程序、数据就越多，计算机的运行速度也就越快。 
       (5) 内存存取速度。内存连续启动两次独立的“读”或“写”操作所需的最短时间，称为存取周期。 
       (6) I/O速度。I/O的速度是指CPU与外部设备进行数据交换的速度。目前系统性能的瓶颈越来越多地体现在I/O速度上。 




 

   第三章Windows XP操作系统
操作系统是配置在计算机硬件上的第一层软件，是控制计算机所有操作的软件。
1.	操作系统的类别
        经过多年的发展，操作系统多种多样。为提高大型计算机系统的资源利用率，操作系统从批处理，多道程序发展为分时操作系统。为了满足计算机处理实时事件的需要，就有实时操作系统。为适应个人计算机系统的需要又出现了桌面操作系统。为适应并行系统的需要，就有了多处理器操作系统。为满足网络和分布计算的需要，就有了网络操作系统和分布式操作系统。此外，还有为支持嵌入式计算机的嵌入式操作系统。
操作系统的主要功能：处理器管理、内存管理、设备管理、文件管理、作业管理
操作系统的五大类型:批处理系统（DOS）、分时操作系统（windows、UNIX）、实时操作系统（LINUX）、网络操作系统（Netware/WindousNT）、分布式系统（Amoeba）
典型操作系统
A.	UNIX
Unix是一个通用、交互式、分时多用户并支持网络的操作系统，是可以运行在各种机型(从微机到巨型机在内)上的通用操作系统。主要适用于网络、大中小型机。
        缺点：软件少，价格贵，难掌握。 
B.	DOS
DOS是单用户、单任务和字符界面的操作系统，主要为16位微型计算机而设计，DOS目前仍在一些微型计算机上运行， 但属于淘汰产品。 
C.	Windows
	界面图形化，操作便捷　
	 采用多任务机制　　　 
	 支持网络功能　　　
	 出色的多媒体功能
	 硬件更容易使用
	 具有众多应用程序的支持
D．	Linux
        Linux是一个免费、源代码开放、自由传播、类似于Unix的操作系统。它既可以做各种服务器操作系统，也可以安装在微机上，并提供上网软件、文字处理软件、绘图软件、动画软件等，它除了命令操作外还提供了类似Windows风格的图形界面，我国自行开发的有红旗、蓝点Linux、麒麟Linux等。缺点是兼容性差，应用软件安装困难，操作性差，使用不习惯。
2.	窗口的基本组成元素和操作
窗口系统提供友好的用户界面，每个窗口都由标题、菜单、控制按钮、滚动条、边框等元素组成。用户可以方便地使用鼠标打开和关闭窗口，通过操作窗口的组成部件来实现窗口的移动、尺寸大小改变和多窗口布局。
打开窗口的方法：
1）双击图标 
2）选择一个图标，使其反像显示，再按回车键
3）右击一个图标，弹出快捷菜单，在该菜单中选择“打开”。
4）如果图标在某一个窗口中，选中该图标后，在“文件”菜单中选择“打开”命令。
关闭窗口的方法：
	按ALT+F4
	双击控制菜单
3.	对话框常见的组成元素     对话框是系统与用户对话、交互的场所，是窗口界面的重要组成成分。对话框有时也用来显示警告信息、解释信息或询问信息。对话框中的标准件包括文本框、列表框、单选按钮、复选框和命令按钮等。
4.	菜单 “开始”菜单、下拉式菜单、弹出式快捷菜单                            
下拉式菜单：① 命令名称显示为灰色，表示当前不可用
            ② 命令名的后面有“…”，单击后将弹出对话框
            ③ 命令名的后面有“→”的，表示该命令有级联菜单。
            ④ 命令名的前面有“√”的，表示该命令正在起作用，如果该命令处在一个组中，该组命令可以复选。
            ⑤ 命令名的前面有“●”，表示该命令被选中，如果该命令处在一个组中，该组命令只能选择一个，并且必须选择一个。
用键盘操作打开下拉式菜单，在菜单项的名称右边有一个带下划线的字母，按住Alt键不放
再按下这个字母，就会打开相应的菜单。例如，按住ALT键不放，再按F键会打开“文件
菜单。
弹出式菜单：这是一种随时随地为用户服务的“上下文相关的弹出式菜单”。将鼠标指向一
个选中对象或屏幕的某个位置，单击鼠标右键，即可打开一个弹出式菜单
5.  文件管理
文件管理是操作系统最常见的组成部分。文件管理主要提供目录及其文件的管理。　
	文件：保存在外部存储设备上的相关信息的集合
	文件存取属性：　
•	只读：只允许授权用户进行读操作。  
•	读写：只允许授权用户进行读和写的操作。 
•	文档：允许任何用户进行读写操作。  
•	隐藏：不允许用户直接看到文件名。  
	文件名的组成及命名规则
	每一个文件必须有一个名字，操作系统才能根据这些文件名来完成对文件的各种操作和管理。文件名由的主文件名和扩展名组成，其间用“.”分开。
	文件名最多可以包含255个字符（包括空格）。
	文件名不能含有以下字符： <、>、\、: 、; 、+。
	不区分大小写。
	文件的通配符由？和*组成。如：A？.EXE 、*.DOC、课程表.*  ？表示一个字符,*表示多个字符
6. 路径
路径即是指从根目录开始，一直到指定文件之间所经过的目录名构成的字符串，它指明了查找文件的具体过程。在路径中，各级子目录间及最后一级子目录和文件名之间用“\”分隔开如：
         C:\Program Files\Microsoft Office\Office\winword.exe
7. 文件及文件夹的选取
选择对象	操作步骤
选择单个对象	将鼠标指针指向欲选择的对象，单击左键
选择多个对象	左键单击欲选择的第一个对象，按住SHIFT键，再左键单击欲选择的最后一个对象。
选择多个不连续对象	先按住CTRL键，再用鼠标分别单击欲选对象
选择全部对象	按（CTRL+A）组合键
取消选择	在未选对象的空白区域单击左键。
8．切换程序的方法  （1）利用任务栏切换 （2） 利用Alt+Tab组合键或Alt+Esc组合键来切换窗口 Alt+Esc组合键只能在没有最小化的窗口之间切换，Alt+Tab在所有窗口切换。
9. 启动Windows“资源管理器”的3种方法
	用鼠标右键单击“开始”按钮，在弹出的快捷菜单中选择“资源管理器”命令
	用鼠标右键单击桌面上“我的电脑”、“我的文档”、“网上邻居”等任一图标，从弹出的快捷菜单中选择“资源管理器”命令
	打开开始“开始”菜单，选择“所以程序-附件-资源管理器”
                    第四章  中文Office 2003
 	中文WORD的使用
1. 中文Word 2003有五种视图：页面视图（系统默认）、大纲视图、Web视图、阅读版式视图、普通视图。
	页面视图 页面视图是中文WORD2003的默认视图。在页面视图中可以显示整个页面的分布情况和文档中的所以元素。例如正文、图形、表格、文本框、页眉页脚以及各种OLE对象等。
	大纲视图 在大纲视图中可以很容易地查看长篇文档的结构。大纲视图中不显示页边距、页眉和页脚、图片和背景灯等。
	Wed视图 可以创建Wed页。在该视图中看到背景和为适应窗口行显示的文本和图行，且图形位置与Wed浏览器中的位置一样。不显示页眉页脚。
	阅读版式视图 阅读版式视图是为了方便用户阅读文档和在阅读时对文本做简单地编辑操作。
2. 文框编辑—插入和改写   插入是指将输入的文本添加到插入点所在位置，插入点后的文本依次往后移动；改写是指输入的文本将替换插入点所在位置的文本。插入和改写两种编辑方式可以通过INSERT键或用鼠标双击状态栏上的“改写”标志来切换。
3.移动光标的主要按键及功能   Home 移动到当前行首 End 移动到当前行尾 
Ctrl+Home 移动到文档的开头 Ctrl+↑向上移动一个段落
4. 文本的选定及撤销 
❤用鼠标选定文本
※ 将鼠标I形指针一道该行的最左边，直到变为一个向右指的箭头。单击左键可选定一整行，不松开鼠标左键向上或向下拖动鼠标即可选择多行文字。当鼠标指针变成右边的箭头时，双击鼠标则选定一个段落；连续单击3下，则选定整篇文档。
※ 将鼠标的I形指针在某个字或词组上双击，就选定了整个字或词。连续三次单击就选定了光标所在的段落。
❤用鼠标和键盘选定文本
1)	要选定一个句子，先按住Ctrl键，然后用鼠标在句子的任何地方单击
2)	要选定一大块文字，将光标移至所选文本的起始处，用滚动条滚动到所选内容的结束处，然后按住Shift键不放，在单击鼠标左键
3)	要选定列块（垂直的一块文字）按Alt键
5. 文档格式设计可分为字符格式设计、段落格式设计、页面格式设计。
❤设置字符格式设计通过单击“格式”工具栏上的按钮或从“格式”菜单中选择“字体”命令  “格式”菜单“字体”命令中由字体、字符间距、文字效果组成。
❤设置段落格式设计可从以下几个方面更改段落的外观：文字对齐方式、缩进、行距、段落间距、制表位、底纹、项目符号和编号方式。
段落的对齐方式有左对齐、右对齐、两端对齐、居中对齐、分散对齐5种。
❤页面格式设计 1》选择纸张大小和页面方向 从“文件”菜单中选择“页面设置”
               2》页边距设置 也在页面设置里面
               3》创建页眉页脚 从视图菜单中选择页眉页脚命令。页眉页脚中可以包括文字或图形，用来说明页与页之间的关系。
               4》分栏 选择“格式”菜单中的“分栏”命令，打开“分栏”对话框.
 	中文Excel的操作
1. 工作簿、工作表和单元格   工作簿就是指在Excel中用来存储并处理数据的文件，它的扩展名是.XLS 默认的工作簿有3张工作表，工作表的名字为Sheet1、Sheet2、Sheet3。单元格是工作表的最小单位，也是Excel用于保存数据的最小单位。
2. 数据输入 输入数据是创建工作表的最基本的工作，即向工作表的单元格中输入文字、数字、日期与时间、公式等内容。Excel提供单个单元格数据输入和系列数据输入自动填充输入法。
（1）单个单元格输入 中文EXCEL中每个单元格中最多可输入32000个字符。
❤文本输入 在单元格中输入的文本会自动靠左对齐。若要输入纯数据的文本应在第一个数字钱加上单引号即可（如’65786）当输入的文本超过了单元格宽度时，如果右边相邻单元格没有内容，则超过的文本会延伸到右边的单元格位置显示醋来；如果右边相邻单元格有内容，则超出的文本不显示出来，但实际内容依然存在。
❤数值输入 在单元格中输入的数值会自动靠右对齐。在计算时，用输入的数值参与计算而不是显示的数值。在输入分数时，应先输入“0”及一个空格，然后再输入分数，否则EXCEL将会把它处理为日期数据。
❤日期和时间输入 常用的内置日期格式与时间格式有；”dd-mm-yy”、“yyyy/mm/dd”、“yy/mm/dd”、“hh:mm:AM”、“mm/dd”。
❤公式输入 先输入一个等号“=”，然后输入公式内容。
（2）系列数据自动填充输入
①相同数据的输入
方法一：选定输入相同数据的区域 输入数据 按Ctrl+Enter键完成
方法二： 用鼠标单击输入相同数据区域左上角第一个单元格 输入数据 将鼠标指针指向该单元格右下角的填充柄，此时鼠标指针变为实心十字形，按下左键拖曳到最后一个单元格，然后松开鼠标左键
②系列数据的输入 如果输入的是文字，则先输入初始数据，将鼠标指针指向单元格右下角的填充柄，按下鼠标左键向下或向右拖曳至填充的最后一个单元格，然后松开鼠标左键即可
如果输入的初始数据位一个数值，则应按住Ctrl键，在拖曳该单元格右下角的填充柄。
3． 单元格引用：相对引用、绝对引用、混合引用
4. 数据清除的功能是将单元格或单元格区域中的数据、格式删除，当要对单元格区域中的数据进行删除时，可以使用数据清除命令。具体操作方法如下；
方法一：利用Del键将所选的单元格中的数据清除。但此方法只能清除单元格或单元格区域中的数据，而不能清除格式。
方法二：在菜单栏中选择“编辑”菜单中的“清除”命令，弹出级联菜单，菜单中包含“格式”、“内容”、“批注”、“全部”4条命令。
 	中文PPT2003
1. PowerPoint 2003的视图：1）普通视图：也是Powerpoint 2003的默认视图 
2）幻灯片浏览视图：使用幻灯片浏览视图可以在窗口中按每行若干张幻灯片缩图的方式顺序显示幻灯片，以便于用户对多张幻灯片同时进行删除、复制和移动，以及方便快速地定位到某张幻灯片。另外，在这里定义幻灯片的切换方式也很方便。
3）幻灯片放映：从当前幻灯片开始放映，直接观察放映中的视觉、听觉效果，实验放映操纵的过程，以便于及时修改。
2．文本的格式化
文本格式化是指幻灯片上文本占位符和文本框中文本的格式设置。文本格式设置，可以针对占位符或文本框中的所有文字，也可以只针对其中选定的文字。格式化的内容包括字体的格式化和段落的格式化。文本占位符和文本框的格式化方法是一样的。对于文本占位符中的字号和行距等格式信息，PowerPoint 2003本身还可以根据文字的多少、占位符的大小以及所作的格式设置自动调节，以达到最佳的效果。
3. 幻灯片放映类型：演讲者放映、观众自行放映、在展台浏览。
(1) 演讲者放映（全屏幕）：这是常规的幻灯片放映方式。在放映过程中，可以人工控制放映进度；如果希望自动放映演示文稿，可以使用“幻灯片放映”菜单中的“排练计时”，设置好每张幻灯片放映的时间，这样放映时可以自动放映。
(2) 观众自行浏览（窗口）：若放映演示文稿的地方是在类似于会议、展览中心的场所，同时又允许观众自己动手操作，可以选择此方式。这是在标准窗口中放映，窗口中将显示自定义的菜单及快捷菜单，这些菜单命令中不含有可能会干扰放映的命令选项，这样可以在任由观众自行浏览演示文稿的同时，防止观众所作的操作损坏演示文稿。
(3) 在展台浏览（全屏幕）：如果幻灯片放映时无人看管，可以使用这种方式，演示文稿会自动全屏幕放映。当选择此项后，PowerPoint 2003会自动选择“循环放映，按Esc键终止”复选项。
第五章 软件技术基础
1．程序设计语言
（1）机器语言和汇编语言
由计算机硬件系统可以识别的指令组成的语言称为机器语言。汇编语言是将机器指令映射为一些可以被人读懂的助记符。由于计算机只能识别机器语言，所以汇编语言通常需要通过汇编程序翻译为机器语言。汇编语言的翻译软件称为汇编程序，它可以将程序员写的助记符直接转换为机器指令，然后由计算机去识别和执行。用机器语言编写的程序是计算机可以直接执行的程序。
用机器语言编写的程序，代码长度短，执行效率高。但是，这种语言的缺点也很明显。
最主要的是编写机器语言程序必须要熟知CPU 的指令代码，编写程序既不方便，又容易出
错，调试查错也非常困难。而且编写的程序只能在特定的机器上运行，没有通用性。
（2）高级语言  高级语言源程序翻译为指令代码有两种做法：编译或者解释。编译通过编译程序来完成。解释则是通过解释程序完成。解释的结果产生可以直接执行的指令。编译的结果是得到目标程序。目标程序也是要经过连接才会得到可执行程序目前应用比较广泛的几种高级语言由FORTRAN/BASIC/PASCAL/C等。
（3）面向对象的语言
（4）未来的语言
3、语言处理程序
语言处理程序是把源程序翻译成机器语言的程序，可分为三种：汇编程序、编译程序和解释
程序。
（1）汇编程序
把汇编语言源程序翻译成机器语言程序的程序称为汇编程序，翻译的过程称为汇编。
汇编程序在翻译源程序时，总是对源程序从头到尾一个符号一个符号地进行阅读分析，一般
用两遍扫描完成对源程序的加工转换工作。汇编语言在翻译的同时，还对各种形式的错误进行检
查和分析，并反馈给用户，以便修改。
反汇编程序也是一种语言处理程序，它的功能与汇编程序相反，它能把机器语言程序转换成
汇编语言程序。
（2）编译程序
编译程序是把高级语言源程序（如Fortran、Pascal、C 等）翻译成目标程序（机器语言程序）
的一种程序，翻译的过程称为编译。
（3）解释程序
解释程序也是一种对高级语言源程序进行翻译处理及的程序。但其处理方式是边读取、边翻译、边执行，解释过程不产生目标程序。解释程序将源程序一句一句读入，对每个语句进行分析和解释，有错误随时通知用户，无错误就按照解释结果执行所要求的操作。程序的每次运行都要求源程序与解释程序参加。
2.各种程序设计语言均包括以下四个成分：
①数据成分。用以描述程序中所涉及的数据。
②运算成分。用以描述程序中所包含的运算。
③控制成分。用以表达程序中的控制构造。
④传输成分。用以表达程序中数据的传输。
3.计算机程序的执行
（1）编辑程序 （2）编译程序 （3）链接程序 （4）运行程序
4.程序设计的步骤：程序说明、程序设计、 、程序定稿、编写代码、测试程序。
结构化程序设计的原则：
	采用自顶向下、逐步求精的方法程序结构
	模块化  把一个大型的程序按照功能分解为若干相对独立的、较小的子程序(即模块)，并把这些模块按层次关系进行组织。 
	限制使用goto语句 严格遵循每个程序段“只有一个入口和一个出口”的原则
5.	结构化基本结构：顺序结构、选择结构、循环结构
6.	结构化程序的描述工具
1)	程序流程图 2）N-S图 3）伪码
7. 面向对象的程序设计 
	对象：在现实生活中，所有东西都是对象，例如某一辆车就是一个对象，指具体的一辆车，某个人也是一个对象，指具体的一个人。对象既可以很简单，也可以很复杂，复杂的对象可以由若干简单的对象构成。
任何对象都有两个共同的特点：对象的属性和对象的操作。一个对象通常由对象名、属性和操作组成。
	属性：属性是用来描述对象的状态，对象的状态又称为对象的静态属性，包括对象内部所包含的信息，每个对象都具有自己专有的内部信息，这些信息说明了对象所处的状态
	封装：封装就是把对象的属性和操作结合成一个不可分割的整体，在这个整体中一些属性(操作)是被保护的，以防外界的干扰和误操作，另一些属性(操作)是公共的，它们作为接口供外界使用。封装的结果就是使一个对象形成接口和实现两个部分。对于用户来说，接口是可见的，实现是不可见的。封装是面向对象方法重要的机制，其目的是有效地实现信息隐藏原则。
	类：是一组具有相同属性和相同操作的对象的集合。一个类中的每个对象都是这个类的一个实例。例如，人就是一个类(不是指具体的某个人)，而具体的一个人就是人类的一个实例(对象)。再比如，定义了一个名为“球”的类，那么，足球、排球、篮球就是“球”类的一个个实例。 
	继承：继承是表达类之间相似性的一种机制，即在已有的类的基础之上增加构造新的类，前者称为父类(或超类)，后者称为子类。子类除自动拥有父类的全部属性和操作外，还可以进一步定义新的属性和操作。如果子类只从一个父类继承，则称为单一继承；如果子类从一个以上父类继承，则称为多重继承。 
	消息：对象间的相互合作需要一个机制协助进行，这样的机制称为“消息”。也就是说，消息是向对象发出的服务请求，是对象和对象之间进行通信的手段。一个对象通过向另一个对象发送消息来请求服务，接收到消息的对象经过解释，然后给予响应。这种通讯机制叫做消息传递。消息要素通常包括：发送对象、接受对象、操作和适当的参数。
	多态性：对象在收到消息时要予以响应，不同的对象收到同一消息可产生完全不同的结果，这一现象叫做多态性。多态性增强了软件的灵活性和重用性。多态性与继承性相结合使软件具有更广的重用性和可扩充性。
8. 面向对象方法的优点：（1）与人类习惯的思维方式一致 （2）稳定性好 （3）可重用行好 (4)易于开发大型软件产品 （5）可维护性好
9. 指令指令是计算机能够识别和执行的命令。
指令是计算机可以识别的命令。计算机可以识别的只有二进制代码。所以，指令也就是
计算机可以识别的二进制代码。所以每一条指令都会告诉计算机做什么：做加法、做减
法，还是把数据从存储器调入CPU，等等。指令一般包含两个部分：指令的操作码，指令的操作数。
10. 算法的定义：算法是一组明确的可执行步骤的有序集合。
算法的5个特征：（1）有穷性 一个算法必须保证执行有限步之后结束
               （2）确定性 算法的每一步骤必须有确切的定义
               （3）可行性 （4）输入 （5）输出
11. 算法设计的基本方法：列举法、归纳法、递归法、减半递推法、回溯法
12．算法时间复杂度：算法中包含简单操作的次数
13. 算法空间复杂度：算法运行过程中临时占用存储空间的大小。一般以数量级的形式给出
14.数据结构的基本概年
a)	数据：数据是描述客观事物的数值、字符以及所有其它能输入到计算机中，且能被计算机处理的各种符号的集合。简言之，数据就是计算机化的信息（或存储在计算机中的信息）。
b)	数据元素：数据元素是组成数据的基本单位,是数据集合的个体，在计算机中通常作为一个整体进行考虑和处理。
c)	数据项：数据元素的最小单位是数据项。
d)	数据对象：数据对象是性质相同的数据元素的集合，是数据的一个子集。
e)	数据对象：数据对象是一组性质相同的值集合以及定义在这个值集合上的一组操作的总称。
f)	数据处理：数据处理是指对数据集合中的各元素以各种方式进行处理，包括对数据的插入、删除、查找、更新、排序等基本运算。
14.	数据结构：相互有关联的数据元素的集合。数据结构的3种结构：（1）线性结构 结构中数据结构之间存在一个对一个的关系。（2）树形结构 结构中数据元素之间存在一个对多个的关系 （3）图形结构或网状结构 多个对多个 树形结构和图形结构统称非线性结构。
15.	数据的存储结构：顺序存储结构、链式存储结构、索引存储结构、散列存储结构。
16.	栈、队列、树和二叉树具体从书上看。
17.	软件危机是指在软件的开发和维护过程中所遇到的一系列严重问题。软件危机主要体现在以下几个方面：① 软件开发的实际成本和进度估计不准确② 开发出来的软件常常不能使用户满意③ 软件产品的质量不高，存在漏洞，需要经常打补丁④ 大量已有的软件难以维护⑤ 软件缺少有关的文档资料⑥ 软件的开发和维护成本不断提高，直接威胁计算机应用的扩大⑦ 软件生产技术进步缓慢，跟不上硬件的发展和人们需求的增长。
18.	软件工程是指应用计算机科学、数学及管理科学等原理，以工程化的原则和方法来开发与维护软件的学科。研究软件工程的主要目的就是在规定的时间、规定的开发费用内开发出满足用户需求的高质量的软件系统(高质量是指错误率低、好用、易用、可移植、易维护等)。为了消除软件危机，人们通过认真研究解决软件危机的方法认识到软件工程是引导软件开发走向工程科学的途径，形成了软件工程的概念。
19.	软件工程包括3个要素：方法、工具和过程。方法是完成软件工程项目的技术手段。工具支持软件的开发、管理、文档生成；过程支持软件开发的各个环节的控制、管理。
20.	软件生命期：软件的生命期是指从概念的形成、问题的提出直到所开发的软件在充分使用之后完全失去使用价值为止的这个过程。大体分为3个时期，即软件定义时期、软件开发时期和软件维护时期。定义时期：问题定义、可行性研究、需求分析（写出需求分析书及用户手册的初稿） 软件开发时期：概要设计阶段、详细设计阶段、编码阶段、测试阶段。 软件维护阶段：软件维护阶段是软件生命其中最长也是最后一个阶段，起主要任务是通过软件的运行，发现和排除软件中存在的错误，并根据运行环境的变换，对软件进行改进和扩充。
21.	软件工程的目标与原则；①抽象（通常采用分层次抽象，即自顶向下、逐层细化的办法，以便控制软件开发过程的复杂性。）②信息隐蔽（采用封装技术，将程序模块的内部实现细节掩藏起来，是模块接口尽量简单）③模块化 ④局部化 ⑤确定性 ⑥一致性 ⑦完备性以及可验证性。
22.	软件开发工具：数据流图、实体联系图、面向对象开发工具、CASE工具。
（1）	数据流图表示不是程序流程图 程序流程图是从对数据进行加工的角度描述系统的，其箭头是控制流，表示的是对数据进行加工的次序，它用于描述怎样解决问题；数据流图则是从数据的角度来描述系统的，其箭头是数据流，表示的是数据流动的方向，它用于描述的是什么问题。
（2）	数据字典是对所有与系统相关的数据元素的一个有组织的列表以及精确、严格的定义。概括地说，数据字典的作用是对数据流图中出现的被命名的图形元素的确切解释。
（3）	实体联系图简称ER图，主要包括实体、联系和属性等3个基本成分。矩形框表示实体，菱形表示联系，椭圆表示属性。
23.	软件测试的目的是为了发现错误而执行程序的过程，软件测试就是要通过预先设计好的若干测试用例来发现程序中的问题。软件测试的方法：白盒测试方法和黑盒测试方法。
白盒测试方法也称为结构测试或逻辑驱动测试。它是根据软件产品的内部工作过程，检查内部成分，以确认每种内部操作符合设计规格要求。白盒测试的基本原则是：保证所测模块中每一独立路径至少执行一次；保证所测模块所有判断的每一分支至少执行一次；保证所测模块每一循环都在边界条件和一般条件下至少各执行一次；验证所有内部数据结构的有效性。
黑盒测试也称为功能测试或数据驱动测试， 黑盒测试完全不考虑程序内部的逻辑结构和内部特性，只依据程序的需求和功能规格说明，检查程序的功能是否符合它的功能说明。黑盒测试只检查程序功能是否按照需求规格说明书的规定正常使用，程序是否能适当的接收输入数据而产生正确的输出信息，并且保持外部信息的完整性。黑盒测试主要用于软件确认测试。主要包括等价类划法、边界值分析法和错误推测法等。
24.	软件测试的步骤：模块测试、组装测试、确认测试、系统测试。
25.	程序的调试的任务是诊断和改正程序中的错误，它与软件测试不同，软件测试是尽可能多的发现软件中的错误。先要发现软件的错误然后借助于一定的调试工具去找出软件错误的具体位置，软件测试贯穿于整个软件生命期，调试主要在开发期。
26.	调试的基本步骤：错误定位、修改设计代码，以排除错误、进行回归测试，防止引进新的错误。
27.	调试的方法：（1）强行排除法 （2）回溯法 （3）原因排除法
                          第六章 数据库技术基础
1.	数据管理技术经历以下三个阶段：人工管理阶段(50年代中期以前)；文件系统阶段(50年代后期到60年代中期)；数据库系统阶段(60年代后期以来)。 
	人工管理阶段
当时外存没有磁盘等直接存取的存储设备；软件没有操作系统，数据的处理是批处理。
人工管理数据具有如下特点： 1)数据不保存 2)数据需要由应用程序自己管理，没有相应的软件来处理数据 3)数据不共享 4)数据不具有独立性。 
	文件系统阶段
50年代后期到60年代中期，在操作系统中有专门的数据管理软件，一般称为文件系统。文件系统是数据库系统发展的初级阶段。用文件系统管理数据具有如下特点：1)数据可长期保存  2)简单的数据管理功能  3)数据共享性差 4)数据的独立性差。 
	3. 数据库系统阶段
60年代末期，人们对文件系统进行了扩充，研制了一种结构化的数据组织和处理方式，才出现了真正的数据库系统。数据库系统的基本特点如下： 1)数据的集成性 2)数据的高度共享性与低冗余性  3)数据独立性高 
2.	数据的独立性包括：
①物理独立性：是指数据的物理结构的改变，如存储设备的更换、物理存储的更换、存取方式改变等都不影响数据库的逻辑结构，从而不致引起应用程序的改变。
②逻辑独立性：是指数据的总体逻辑结构改变时，如修改数据模式、改变数据间的联系等，不需要修改相应的应用程序。
3.	数据库的基本术语
（1）数据(Data)
定义：数据是描述事物的符号记录。数据的表现形式不仅是数字，还包括字符（文字和符号）、图表（图形、图像和表格）及声音、语言等 。信息是从原始数据中经过筛选、提炼等加工后，产生的对决策有影响的数据。 
（2）数据库(Database)定义：数据库(DB)是长期储存在计算机内的、有组织的、可共享的数据的集合。数据库有以下特点：1)数据结构化 2)实现数据共享 3)减少数据的冗余   4)数据独立。
（3）数据库管理系统(Databbase Management System简称DBMS)定义：数据库管理系统它是位于用户和操作系统(OS)之间的一层数据管理软件，负责数据库中数据组织、数据操纵、数据维护、数据控制及保护和数据接口等。 
（4）数据库管理员(Database Adminstrator简称DBA)定义：由专职人员对数据库进行规划、设计、维护、监视等，称这些专职人员为数据库管理员。数据库管理员的具体职责包括： 1)数据库定义与设计 2)数据库运行与维护  3)数据库的改进和重组重构。 
（5）数据库系统(Database System简称DBS)定义：数据库系统一般由数据库、数据库管理系统(及其开发软件)、系统平台、应用系统和人员构成。
4.	(1)数据库系统的三级模式。
❤外模式也称子模式或用户模式，还称为用户级模式。它是数据库用户能够看见和使用的局部数据的逻辑结构和特征的描述，是数据库用户的数据视图。
❤模式也称逻辑模式，还称概念模式。是数据库中全体数据的逻辑结构和特征的描述。
❤内模式也称存储模式，还称物理模式。它是数据物理结构和存储方式的描述。
5.	数据模型的基本概念：数据模型根据不同的应用层次划分为三种类型：概念模型、逻辑模型、物理模型。
	概念模型：也称信息模型。它是按用户观点来对数据和信息建模，主要用于数据库设计。它与具体数据库管理系统无关，与具体的计算机平台无关。目前，较为流行的概念模型有E-R模型、扩充的E-R模型、面向对象模型等。
	逻辑模型：又称数据模型。它是按计算机系统观点对数据建模，主要用于DBMS的实现。目前数据模式有很多种，包括层次模型、网状模型和关系模型、面向对象模型等。
	物理模型：它是一中面向计算机物理表示的模型，此模型给出了数据模型在计算机上的物理结构的表示。
6.	数据模型的三要素：
①数据结构。数据结构用来描述系统的静态特征。它主要描述数据的类型、内容性质以及数据间的联系等。 
②数据操作。数据操作用于描述系统的动态特征。它主要描述在相应数据结构上的操作类型与操作方式。数据库主要有检索和更新(包括插入、删除和修改)两类操作。
③数据约束条件。 数据约束条件是一组完整型规则的集合，它描述了数据及其联系应具有的制约和依赖规则。
7.	在数据库领域中最常用的数据模型有层次模型、网状模型、关系模型三种模型。
8.	关系模型是数据库领域中目前最重要的一种数据模型。关系模型的本质是一张二维表，关系模型中，一张二维表就称为一个关系。 
(1)	关系模型的数据结构。关系模型采用二维表来表示，简称表。如下表是一张学生登记表，它由行(元组)和列(属性)组成。 
(2)	外键：二维表中某个属性或属性组合虽不是该表的关键字或只是关键字的一部分，但却是另外一个表的关键字时，称该属性或属性组合为这个表的外部关键字或外键。
(3)	元组也被称为记录，表中的一行称为一条记录
(4)	属性页称为字段，表中的一列为一个属性，每个属性都有一个名称，也被称为字段名。
(5)	主键或主关键字，是表中的某个属性或属性组，用来唯一的确定一个元组，一个表中只有一个主键
(6)	值域是属性的取值范围，例如人的性别只能是“男”或“女”。因此性别的值域为（难，女）。
9.	关系二维表一般具有下面几个性质： 1) 元组个数有限性 2) 元组的唯一性  3)元组次序的无关性  4)元组分量的原子性 5)属性名的唯一性  6)属性的次序无关性  7) 分量值域的同一性 
10.	关系模型的约束条件。关系模型定义三种数据约束条件：
（1）	实体完整性约束条件。实体完整性约束要求关系中主码的任何属性都不能为空。这是数据库完整性的最基本的要求，因为主码唯一标识元组，如为空则不能为主码。
（2）	参照完整性约束条件。参照完整性约束是对关系间引用数据的一种限制。即在关系中的外键要么是所关联关系中的实际存在的元组，要么就为空值。比如在下面关系中：职工关系(职工编号，姓名，性别，部门编号)部门关系(部门编号，部门名称，部门经理)职工编号是职工关系的主码，而外码为部门编号，职工关系与部门关系通过部门编号关联，参照完整性要求职工关系中的部门编号的值在部门关系中必有相应元组。
（3）	用户定义的完整性约束条件。用户定义的完整性约束条件是某一具体数据库的约束条件，是用户自己定义的某一具体数据必须满足的语义要求。其中前两者约束条件由关系数据库系统自动支持。对后者，则由关系数据库系统提供完整性约束语言，用户利用该语言定义出约束条件。  

11.	传统的集合运算：并、交、差。 专门的关系运算包括选择、投影、连接、除。
(1)	选择：选择运算是根据某些条件对关系做水平分割，即选取符合条件的元组。
(2)	投影：投影运算是从关系内选择出若干属性列组成新的关系。
(3)	连接：连接也称为θ联接。它是从两个关系的笛卡尔积中选取属性间满足一定条件的元组组成新的关系。
12.	2. 结构化查询语言SQL的组成
13.	SQL语言包括数据定义、数据查询、数据操纵、数据控制4个方面。数据定义（DDL）包括定义基本表、定义视图、定义索引3部分。数据查询是建立数据库的主要目的，SQL语言提供了SELECT语句进行查询。数据操纵包括数据检索和更新两部分功能。数据控制是指控制用户对数据的存储权力。
14.	数据库设计一般分为以下六个阶段： 
① 需求分析阶段
进行数据库设计首先必须准确分析用户的需求，按需求合理的设计系统。
②概念设计阶段
概念结构设计是整个数据库设计的关键，它通过对用户需求进行综合、归纳与抽象，形成一个独立于具体DBMS的概念模型。
③逻辑设计阶段
该阶段是将概念结构转化为某个DBMS所支持的数据模型，并对其进行优化，得到数据库的逻辑模型。
④物理设计阶段
数据库物理设计是为逻辑数据模型选取一个最合适应用环境的物理结构（包括存储结构和存取方法）。
⑤实现阶段
在数据库实施阶段，设计人员运用DBMS提供的数据语言及其宿主语言，根据逻辑设计和物理设计的结果建立数据库，编制与调试应用程序，组织数据入库，并进行试运行。
⑥ 运行和维护阶段
数据库应用系统经过试运行后即可投入正式运行。在其运行过程中必须不断对其进行评价、调整与修改。
15.	视图设计一般有三种方法：自顶向下、自底向上、由内向外。

第七章  计算机网络技术
1.	计算机网络的定义与分类 
定义:计算机网络是利用通信设备和线路将分布在不同地理位置的、功能独立的多个计算机系统互连起来，实现网络中资源共享和通信的系统。
从系统功能的角度来看，一个网络包括三个组成部分：
        (1) 通信子网：负责数据通信，是实现网络通信功能的设备及其软件的集合。(如传输线路、通信设备)
        (2) 资源子网：实现网络资源共享的设备和软件集合。 (如计算机、软件、网络数据等)
        (3) 通信协议：通信双方共同遵守的规则和约定。
分类 ---- 从规模上可以分为以下几种：局域网→城域网→广域网→互联网
2.	计算机网络拓扑结构
    在计算机网络中，人把计算机、服务器、交换机、路由器等网络设备抽象为“点”，把网络中的电缆等通信介质抽象为“线”，这样就可以将一个复杂的计算机网络系统抽象为由点和线组成的几何图形。人们称这种图形为网络的拓扑结构。
网络拓扑结构的类型：
(1) 总线型网络
将所有的节点都连接到一条电缆上布线方式。设备：网卡、同轴电缆、连接头 特点: 安装简便，成本低，但故障诊断较困难。说明：该拓扑结构基本被淘汰。
(2) 星型网络
由中央节点与各个计算机连接组成的网络。设备：网卡、双绞线、交换机。特点：控制简单、故障诊断容易、容易在网络中增加新的站点。缺点是中心节点负担较重。说明：该拓扑结构在局域网中应用最广。
  (3) 环型网络      
 环型网络各个结点在网络中形成一个闭合的环，信息在环中作单向流动，可以实现任意两个结点之间的通信。说明：该拓扑结构基本被淘汰。     
(4)	树型网络  
树型网络是星型网络的一种变体，它是一个树形层次结构的网络拓扑。
(5) 网状型网络     
   网状型网络的每一个节点都与其他节点有一条专业线路相连。     
在上述5种拓扑结构中，前3种主要用于局域网。另外，在实际网络中，特别是大型的网络结构中，网络的拓扑结构一般是上述几种网络相互连接而成，整个网络并没有一个统一的拓扑结构。
3.	计算机网络性能指标
•	带宽：网络上能够同时传输信息的最大容量。 
•	时延：指一个数据分组从网络的一端传输到目标端所需要的时间。 
•	网络容量：指一个网络中所能容纳的最大的网络终端数目。 
•	支持的协议与服务：网络所支持的协议越多，则能提供的服务也越多。 
4.	ISO OSI/RM模型
 OSI是一个七层网络模型，包括物理层、数据链路层、网络层、传输层、会话层、表示层和应用层。每一层均有自己的一套功能集，并与紧邻的上层和下层交互作用。
☞物理层：该层负责原始的比特流数据信号的传送以及定义计算机和通讯设备之间的接口标准。
☞数据链路层：负责网络内部的帧传输，用于建立、维护和释放数据链路，以及传输差错的检出与恢复。
☞网络层：解决的是网络与网络之间的通信问题。即无论两台计算机相距多远，中间相隔多少个网络，这一层保障它们可以互相通信。 
☞传输层：作用是把数据可靠地从一方送到另一方，解决的是数据在网络之间传输的质量问题。该层传送的信息单位是报文。 
☞会话层：功能包括：负责建立和终止网络的数据传输。 
☞表示层：负责数据的表示，比如发送数据之前的加密，接收数据时的解密，中英文的翻译等等。
☞应用层：该层提供网络与用户应用软件之间的接口服务。常用的电子邮件服务，文件传输服务等都是这一层提供的。
在OSI的7层模型中，网络层以下3层表现为通讯子网，之上的各层表现为资源子网。
5.	计算机网络硬件。 
①服务器：是提供网络服务的主机，一般网络服务器要安装相关的服务软件并能被网络中的其它计算机访问。网络服务器有文件服务器、WWW服务器、邮件服务器、通信服务器、数据库服务器等。 
②客户机：有时也称为工作站，通过它可以访问服务器上的资源。 
常见的网络通信设备有网卡、中继器、网桥、集线器、交换机、路由器等。
③网络接口卡：简称网卡，它能够使工作站、服务器、打印机或其他节点通过网络介质接收并发送数据。全球每个网卡都有一个唯一的网卡地址(MAC)，网卡属于OSI模型的物理层的设备。 
④中继器：由于信号在传输过程中有衰减，中继器作用是放大信号以使其传输得更远一些。中继器属于OSI模型的物理层的设备。 
⑥ 集线器：也称为HUB，它只是一个信号放大和中转的设备，有多个端口连接一组工作站。集线器的基本功能是信号分发，把一个端口接收的信号向所有端口分发出去。因而容易形成数据堵塞。集线器属于OSI模型的物理层的设备。 
⑦ 网桥：具有单个的输入端口和输出端口的设备，它像一个聪明的集线器，将两个相似的网络连接起来，并对网络数据的流通进行管理。网桥属于OSI模型的数据链路层设备。 
⑧交换机：交换机又叫智能集线器或多端口网桥，它的每一个端口都扮演一个网桥的角色，即数据在转发过程中具有过滤作用，在交换机内部有一个端口与网卡地址对照表，它负责将每一信息包独立地从源端口送至指定网卡地址的目的端口，一个端口工作时不会影响到其它端口的传输。交换机的最基本功能就是集中连接网络设备（如服务器、工作站、路由器、网络打印机等），共同构成星形网络。 
⑨路由器：主要用于互连局域网和广域网，实现不同网络互相通信。在互联网络环境下，信息从一个网络传到另一个网络时，有一个选择最佳路径进行通信的问题，这个最佳路径由路由器提供。路由器属于OSI模型的网络层设备。 
⑩网关：是最复杂的网络连接设备，主要用于连接差别非常大的异种网络，与路由器相比，网关主要工作在OSI的传输层以上。网关按功能可分为以下三类：① 协议网关 ② 应用网关。③ 安全网关。       
6.	计算机网络软件
网络软件系统主要包括有：网络操作系统；网络通信协议；网络工具软件；网络应用软件 
7.	网络IP地址 
 为了使计算机相互识别并进行通信，每台连入互联网中的计算机都有一个“号码”，这个“号码”称为该计算机的因特网地址，由于这个地址是在IP协议中定义并由该协议处理的，因此通常称为IP地址。IP协议是TCP/IP协议族中最为核心的协议，它是网络层的协议。在TCP/IP中，IP地址是一个很基本的概念，是理解网络通信的一个重要基础。
Internet接入方式 计算机接入Internet的最基本的方式有三种：通过局域网接入、电话线接入、有线电视电缆接入。另外，还可以通过无线方式接入。
8.	域名系统 域名:为方便记忆而为计算机进行命名。与IP地址作用同，但便于记忆。(通常95%的个人用户入网后由ISP提供一个动态IP地址，没有域名)
域名系统 DNS :完成域名向IP地址的转换。是由若干个域名服务器程序完成的。域名解析就是将域名翻译成IP地址的过程。
9.	WWW服务
  (1) Web(万维网) 所谓WWW(World Wide Web)，也称或Web，是建立在客户机/服务器模型之上，以HTML语言和HTTP协议为基础，能够提供面向各种Internet服务的信息浏览系统。
万维网的工作方式: 
        WWW是基于客户机/服务器方式工作的。客户机与服务器各自完成不同的功能，其中：
         ① 浏览器。是一种安装在客户端专门用于定位和访问Web信息，获取相关资源的导航工具。通过浏览器，除了可以访问WWW资源空间的信息外，还可以访问包括Telnet、FTP、电子邮件等全部的Internet资源。
         ② WWW服务器(又称Web服务器)。存放有网页，即浏览器中所看到的画面。客户程序向服务器程序发出请求，服务器程序向客户程序送回客户所要的网页文档。
(2) URL(统一资源定位符)
         也称为Web地址或网址。
         一个完整的URL包含三个部分：第一部分使用的是通讯协议；第二个部分是服务器的名称或IP地址；第三是部分是网页或文件的文件名。三者组合起来，就是完整的URL。例如:
         http://主机全名[：端口号]/文件路径/文件名
         ftp://用户名@服务器域名/目录文件
         telnet:// 服务器域名
         例：ftp://ftp.microsoft.com/Softlib/
                 http://blog.sina.com/cn/main/
(3) 主页
        我们把只使用域名，如(http://www.scau.edu.cn)就可以浏览到的第一个网页称为该网站的主页，主页实际上也是一个Web站点的首页。通过主页中的超链接就可以浏览该网站的其它页面。 
       网页(Web页):浏览器中所看到的画面。
(4) 搜索引擎
        是专业搜索网站为用户提供的检索信息的搜索工具，常见有百度搜索(www.baidu.com)、Google搜索(www.google.com)、雅虎搜索(www.yahoo.cn)、搜狐(www.sohu.com)等。 
10.	文件传输(FTP)
FTP就是将远程计算机中的文件拷贝到自己计算机中，或将本地计算机中的文件拷贝到远程计算机中。
11.	中国科学技术网（CSTNET）、中国教育和科研网（CERNET）、中国公用计算机互联网（CHINANET）和中国金桥网（CHINAGBN），其中CSTNET和CERNET是为科研、教育服务的非营利性质的Internet,CHINANET和CHINAGBN是为社会提供Internet服务的经营性Internet.
第八章  多媒体技术
1．多媒体计算机的概念：从一般意义上讲，在计算机或通讯领域，媒体是指信息的载体或者信息的存储实体，信息载体包括数字、文字、声音、图形、图像、视频，信息的存储实体包括磁盘、磁带、光盘、U盘等。而就多媒体计算机而言，媒体则是指信息载体。 
根据国际电信联盟的定义，媒体可分为5种：感觉媒体、 表示媒体、显示媒体、存储媒体、传输媒体多媒体：通常所指的多媒体就是文字、声音、图像、图形、动画、视频等各种媒体在计算机统一管理下的有机结合。 
2. 多媒体特点是：
   (1) 多样性：多媒体不只处理一种媒体，而是综合处理多种媒体，包括图文声像信息。
   (2) 集成性：多媒体不是多种媒体简单的收集，而是被有机地集成为系统。
   (3) 交互性：多种媒体系统可以实现人机互动，用户可以根据需要来使用系统。
多媒体信息的主要元素 
1．文本：包含字母、数字、汉字等基本元素。 
2．图形：又称矢量图。
3．图像：又称位图或像素图。
4. 动画：采用编程或动画软件创作的连续画面。
5. 音频：指人耳能听到的连续变化的音波。
6. 视频：动态的影视图像。 
3. 多媒体计算机硬件系统
(1) 基本硬件设备:
      ① 光盘存储器
     光盘存储器由光盘和光盘驱动器构成。
     ② 音频卡
     又名“声卡”，主要用于处理声音，是多媒体计算机的基本配置。目前许多计算机的主板上都集成了声卡的功能，声卡不再以单独形式存在。
声卡的作用主要有：
    ① A/D(模/数)转换——将作为模拟量的自然声音转化成数字化的声音，然后以文件形式保存在计算机中。
    ② D/A(数/模)转换——把数字化的声音转换成模拟量的自然声音并输出到声音还原设备(例如耳机、有源音箱、音箱放大器等)中。
    ③ 输入、输出功能——利用声卡的输入/输出端口可以将模拟信号引入声卡并转换成数字信号；也可以将数字信号转换成模拟信号送到输出端口驱动音响设备发出声音。
声卡的主要接口：
   ① 触摸屏：属于输入设备，可通过手指直接触及屏幕上的菜单、光标、接钮等。
    系统主要由传感器、控制部件、驱动程序组成。 
    当用手指或其它设备触摸显示器前面的触摸屏时，所摸到的位置以坐标形式被触摸屏控制器检测到，并通过接口送到CPU，从而确定用户所输入的信息。 
   ② 视频卡：插在主机板的扩展槽内，可以对视频信号进行数字化转换、编辑和处理，以及保存数字化文件。
通常使用的视频采集卡可接收模拟视频源的信号(如录像机、电视机、LD影碟机等)，并对该类信号进行数字化处理，然后再压缩编码成数字视频信号。
    扫描仪：是一种图形输入设备。配合适当的应用软件后，扫描仪还可以进行中、英文智能识别。 
4.数字音频文件格式:WAV、mP3、RA、MID、APE、AIF。     
5.图像与图形的区别
图像由像素构成，像素是组成图像最基本的元素，每个图像点用若干个二进制位进行描述。图像通常用于表现自然景观、人物、动物、植物等复杂的场景。 图形是由具有方向和长度的矢量线段构成。图形使用坐标、运算关系以及颜色数据进行描述，因此把图形叫做“矢量图”。图形的数据量小，常用于表现直线、曲线以及由各种线段围成的图形，不适于描述色彩丰富、复杂的自然影像。 
6.动画和视频常见的文件格式：SWF/AVI/DV/RM/RMVB
