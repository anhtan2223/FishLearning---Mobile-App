drop database FishLearning ;
create database FishLearning ;
use FishLearning ;

create table Role(
		RoleID int primary key auto_increment ,
        Description varchar(50) 
);

insert into Role(Description)
value 	("Admin") ,
		("Nguoi Day"),
		("Nguoi Hoc") ;

create table User(
		UID int primary key auto_increment ,
        Name varchar(50) NOT NULL,
        Email varchar(50) NOT NULL,
        Username varchar(50) NOT NULL UNIQUE,
        Password varchar(100) NOT NULL,
        RoleID int NOT NULL,
        foreign key(RoleID) references Role(RoleID)
);
insert into user(name,email,username,Password,RoleID)
value 	("Admin","admin@gmail.com","admin","12345","1") ,
		("Nguoi Day 1","day1@gmail.com","day1","12345","2") ,
        ("Tạ Hồng Thư","day2@gmail.com","day2","12345","2") ,
        ("Lý Lan Phương","day3@gmail.com","day3","12345","2") ,
        ("Hồ Gia Bảo","day4@gmail.com","day4","12345","2") ,
        ("Dương Ngọc Quế","day5@gmail.com","day5","12345","2") ,
        ("Đỗ An Nam","day6@gmail.com","day6","12345","2") ,
        ("Trang Hoàng Việt","day7@gmail.com","day7","12345","2") ,
        ("Nguyễn Bảo Huỳnh","day8@gmail.com","day8","12345","2") ,
        ("Anh Tan","tan@gmail.com","anhtan","12345","2") ,
        ("Le Sy Anh Tan","lsatan@gmail.com","lsatan","12345","3") ,
        ("Lý Phi Ðiệp","hoc1@gmail.com","hoc1","12345","3") ,
        ("Nghiêm Cát Uy","hoc2@gmail.com","hoc2","12345","3") ,
        ("Phí Trung Nhân","hoc3@gmail.com","hoc3","12345","3") ,
        ("Liều Ðình Na","hoc4@gmail.com","hoc4","12345","3") ,
        ("Đặng Bảo Thái","hoc5@gmail.com","hoc5","12345","3") ,
        ("Đỗ Phương Nam","hoc6@gmail.com","hoc6","12345","3") ,
        ("Mạc Minh Nhân","hoc7@gmail.com","hoc7","12345","3") ,
        ("Phạm Đăng Quang","hoc8@gmail.com","hoc8","12345","3") ,
        ("Doãn Minh Vương","hoc9@gmail.com","hoc9","12345","3") ,
        ("Huỳnh Hưng Ðạo","hoc10@gmail.com","hoc10","12345","3") ,
        ("Phó Cát Uy","hoc11@gmail.com","hoc11","12345","3") ,
        ("Tạ Minh Triệu","hoc12@gmail.com","hoc12","12345","3") 
;
create table Label(
		LabelID int primary key auto_increment ,
        Description varchar(50) 
);
insert into Label(Description)
value 	("Programming Language") ,
		("Computer Science Fundamentals") ,
        ("Networking") ,
        ("Software Engineering") ,
        ("Label 5") ;
        
create table Class(
	ClassID int primary key auto_increment ,
    NameClass varchar(50) not null,
    Subtitle varchar(50)  ,
    TeacherID int not null,
	DateCreate DATE 	  Not null,
    LabelID int 		  ,
    foreign key(TeacherID) references User(UID) ,
    foreign key(LabelID) references Label(LabelID)
);
insert into Class(NameClass,Subtitle,TeacherID,DateCreate,LabelID)
value		("DataStruct and Algorithm","Nam 2023-2024"	, 8 , "2023-10-25" 	, 1) ,
			("Data Mining","Nam 2023-2024"				, 7 , "2023-11-25" 	, 1) ,
			("OOP","Nam 2023-2024"						, 3 , "2023-9-25"	, 1) ,
			("Graph Theory","Nam 2023-2024"				, 8 , "2023-9-25" 	, 1) ,
			("Aftifical Inteligent","Nam 2023-2024"		, 5 , "2023-9-25" 	, 1) ,
			("Math Basic","Nam 2023-2024"				, 6	, "2023-9-25" 	, 2) , 
			("Advanced Data Structures", "Nam 2023-2024", 5, "2023-12-15", 1),
			("Computer Networks", "Nam 2023-2024", 9, "2023-11-28", 3),
			("Web Development", "Nam 2023-2024", 3, "2023-10-30", 4),
			("Software Engineering", "Nam 2023-2024", 10, "2023-11-02", 4),
			("Database Management", "Nam 2023-2024", 6, "2023-10-29", 2),
			("Operating Systems", "Nam 2023-2024", 5, "2023-11-07", 3),
			("Digital Signal Processing", "Nam 2023-2024", 4, "2023-12-05", 5),
			("Computer Architecture", "Nam 2023-2024", 7, "2023-12-10", 3),
			("Object-Oriented Analysis and Design", "Nam 2023-2024", 9, "2023-12-12", 4),
			("Introduction to Python Programming", "Nam 2023-2024", 9, "2023-11-20", 1) ,
			("Image Processing Fundamentals", "Nam 2023-2024", 8, "2023-11-05", 5),
			("Speech Recognition", "Nam 2023-2024", 9, "2023-11-10", 5),
			("Digital Image Analysis", "Nam 2023-2024", 10, "2023-11-15", 5),
			("Biomedical Signal Processing", "Nam 2023-2024", 7, "2023-11-20", 5) , 											
			("Machine Learning Basic","Nam 2023-2024"	, 2	, "2023-9-25" 	, 1) ,
			("Mobile App Development", "Nam 2023-2024", 4, "2023-11-25", 4),
			("Cloud Computing", "Nam 2023-2024", 3, "2023-12-02", 3),
			("Cybersecurity Fundamentals", "Nam 2023-2024", 8, "2023-12-09", 3),
			("Big Data Analytics", "Nam 2023-2024", 10, "2023-12-16", 1),
			("Internet of Things (IoT)", "Nam 2023-2024", 2, "2023-12-23", 3),
			("Game Development with Unity", "Nam 2023-2024", 5, "2023-12-30", 1),
			("Blockchain Technology", "Nam 2023-2024", 7, "2024-01-06", 2),
			("Data Visualization", "Nam 2023-2024", 10, "2024-01-13", 1),
			("Embedded Systems Design", "Nam 2023-2024", 6, "2024-01-20", 3),
			("Natural Language Processing", "Nam 2023-2024", 4, "2024-01-27", 5); 
create table Enrollment(
	ClassID int ,
    StudentID int ,
    DateEnroll Date not null ,
    primary key(ClassID,StudentID),
    foreign key(ClassID) references Class(ClassID) ,
    foreign key(StudentID) references User(UID)
);
insert into Enrollment
value 	 
	(1, 21, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(1, 14, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(2, 18, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(2, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(2, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(3, 22, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(3, 17, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(4, 23, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(4, 20, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(5, 19, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(5, 16, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(5, 11, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(5, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(5, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(6, 21, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(6, 14, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(6, 16, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(7, 18, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(7, 23, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(7, 20, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(8, 22, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(8, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(9, 17, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(9, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(9, 16, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
    (10, 19, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(10, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
    (10, 17, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(10, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(11, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(11, 21, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(11, 22, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(12, 23, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(12, 11, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(12, 14, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(12, 16, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(13, 20, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(13, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(14, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(14, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(14, 18, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(14, 22, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(15, 11, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(15, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(15, 14, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(16, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(16, 17, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
    (16, 14, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(16, 19, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(16, 21, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(17, 20, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(17, 23, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(17, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(18, 17, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(18, 16, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(18, 11, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(18, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(19, 22, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(19, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(20, 18, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(20, 21, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(21, 19, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(21, 23, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(22, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(22, 14, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(22, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(23, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
    (23, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(23, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(24, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(24, 16, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(25, 20, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(25, 21, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(26, 11, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(26, 23, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(27, 18, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(27, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(28, 19, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(28, 14, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(28, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
    (28, 18, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(29, 12, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(29, 16, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(29, 22, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(30, 17, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(30, 15, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(31, 20, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(31, 23, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY)),
	(31, 13, DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 60) DAY));
    

create table Topic(
	TopicID int primary key auto_increment ,
    Title varchar(50) ,
    ClassID int ,
    foreign key(ClassID) references Class(ClassID)
);
insert into Topic(Title , ClassID)
value 
		("Introduction to Data Structures", 1),
		("Arrays and Linked Lists", 1),
		("Stacks and Queues", 1),
		("Trees and Graphs", 1),
		("Sorting Algorithms", 1),
		("Searching Algorithms", 1),
		("Algorithm Analysis", 1) ,
		("Chương 1 ",6) ,
		("Chương 2 ",6) ,
        ("Chương 3 ",6) ,
        ("Giảng Dạy",7) ,
        ("Thực Hành Buổi 1",7) ,
        ("Thực Hành Buổi 2",7) ,
        ("Thực Hành Buổi 3",7) ,
        ("Introduction to Blockchain", 28),
		("Blockchain Technology Fundamentals", 28),
		("Decentralized Networks", 28),
		("Smart Contracts", 28),
		("Consensus Mechanisms", 28),
		("Cryptocurrencies", 28),
		("Blockchain Security", 28) ,
        ("Introduction to Image Processing", 19),
		("Digital Image Processing Techniques", 19),
		("Image Analysis Algorithms", 19),
		("Image Segmentation Methods", 19),
		("Feature Extraction and Pattern Recognition", 19),
		("Image Enhancement and Restoration", 19),
		("Medical Image Processing", 19);


create table TextBox(
	TextID int primary key auto_increment ,
    Content varchar(300) ,
    TopicID int ,
    foreign key(TopicID) references Topic(TopicID)
);
insert into TextBox(Content , TopicID)
value 	
		("Introduction to Data Structures: This topic covers basic concepts and terminology in data structures.", 1),
		("Arrays and Linked Lists: Learn about arrays, linked lists, and their implementations in different programming languages.", 2),
		("Stacks and Queues: Understand the concepts of stacks and queues, and how they are used in algorithms and applications.", 3),
		("Trees and Graphs: Explore tree and graph data structures, including traversal algorithms and applications.", 4),
		("Sorting Algorithms: Study various sorting algorithms such as bubble sort, insertion sort, and quicksort.", 5),
		("Searching Algorithms: Learn about searching algorithms including linear search, binary search, and depth-first search.", 6),
		("Algorithm Analysis: Analyze the efficiency and complexity of algorithms using Big O notation and other techniques.", 7) ,
		("Phòng 205" , 12) ,
		("Phòng 205" , 13) ,
        ("Phòng 205" , 14) ,
        ("Tài Liệu Giảng Dạy" , 11) ,
        ("Introduction to Blockchain: This topic covers the basic concepts of blockchain technology and its applications in various industries.", 15),
		("Blockchain Technology Fundamentals: Learn about the underlying principles and components of blockchain technology.", 16),
		("Decentralized Networks: Understand the concept of decentralized networks and their role in blockchain systems.", 17),
		("Smart Contracts: Explore smart contracts, self-executing contracts with the terms of the agreement between buyer and seller being directly written into lines of code.", 18),
		("Consensus Mechanisms: Study different consensus mechanisms used in blockchain networks such as Proof of Work (PoW) and Proof of Stake (PoS).", 19),
		("Cryptocurrencies: Learn about cryptocurrencies, digital or virtual currencies that use cryptography for security and operate independently of a central bank.", 20),
		("Blockchain Security: Understand the security challenges and best practices in blockchain technology to prevent unauthorized access and data breaches.", 21),
        ("Introduction to Image Processing: This topic covers the basic concepts of image processing and its applications in various fields such as computer vision, medical imaging, and remote sensing.", 22),
		("Digital Image Processing Techniques: Learn about various digital image processing techniques including filtering, transformation, and morphological operations.", 23),
		("Image Analysis Algorithms: Study different image analysis algorithms used for tasks such as object detection, recognition, and classification.", 24),
		("Image Segmentation Methods: Explore image segmentation methods for partitioning an image into multiple segments to simplify the representation of an image.", 25),
		("Feature Extraction and Pattern Recognition: Understand feature extraction techniques and pattern recognition algorithms used in image processing for identifying objects and patterns.", 26),
		("Image Enhancement and Restoration: Learn techniques for enhancing and restoring digital images to improve their quality and visibility.", 27),
		("Medical Image Processing: Explore applications of image processing in the field of medicine, including medical image acquisition, processing, and analysis.", 28);
;
Create table DocType(
	DTID int primary key auto_increment ,
    Type varchar(50)
);
insert into DocType(Type)
value 	("Word")  ,
		("Excel") ,
        ("PDF")
        ;

create table Document(
	DocID int primary key auto_increment,
    Discribe varchar(50) ,
    DocType int ,
    TopicID int ,
    foreign key(DocType) references DocType(DTID) ,
    foreign key(TopicID) references Topic(TopicID)
);
insert into Document(Discribe,DocType,TopicID) 
value	("Lý Thuyết Chương 1",3,8) ,
		("Lý Thuyết Chương 2",3,9) ,
        ("Lý Thuyết Chương 3",3,10) ,
        ("Giới Thiệu Môn Học",3,11) ,
        ("Giải Thuật KNN",3,11) ,
        ("Giải Thuật Bayes",3,11) ,
        ("Cây QUyết Định - Decision Tree",3,11),
        ("Hồi Quy",3,11) ,
        ("Clustering",3,11) ,
        ("Hướng Dẫn Thực Hành Buổi 1",3,12) ,
        ("Hướng Dẫn Thực Hành Buổi 2",3,13) ,
        ("Hướng Dẫn Thực Hành Buổi 3",3,14) ,
        ("Introduction to Blockchain Guide", 1, 15),
		("Blockchain Technology Overview Whitepaper", 3, 16),
		("Decentralized Networks Case Studies", 3, 17),
		("Smart Contracts Implementation Examples", 3, 18),
		("Consensus Mechanisms Comparison Chart", 3, 19),
		("Cryptocurrencies Market Analysis Report", 3, 20),
		("Blockchain Security Best Practices Handbook", 3, 21);
;
create table Test(
	TestID int primary key auto_increment ,
    TestName varchar(50) ,
    NumberQues int ,
    Time TIME ,
    TopicID int ,
    foreign key(TopicID) references Topic(TopicID)
);
insert into Test(TestName,NumberQues,Time,TopicID)
value 	("Bài Kiểm Tra Chương 1",3,"0:10:00",8) ,
		("Bài Kiểm Tra Chương 2",3,"0:10:00",9) ,
        ("Bài Kiểm Tra Chương 3",3,"0:10:00",10) 
;

create table Question(
	QuesID int primary key auto_increment,
    Detail varchar(500) ,
    TestID int ,
    foreign key(TestID) references Test(TestID)
);
insert into Question(Detail,TestID)
value 	("Đâu Là Số Nguyên Tố",1) , 
		("Chọn Giá Trị Là Hợp Số",1 ) ,
        ("Đâu Là 2 Số Nguyên Tố Cùng Nhau",1) ,
        ("Trong đại số Boole, biểu diễn tất cả các khả năng của một biến bằng hai giá trị là gì?",2) ,
        ("Phép toán AND giữa hai giá trị boolean true và false sẽ trả về giá trị nào?",2) ,
        ("Biểu diễn phép toán OR giữa hai biến boolean A và B bằng công thức nào dưới đây?",2) ,
        ("Trong đại số tuyến tính, ma trận đơn vị có các phần tử trên đường chéo chính bằng 1 và tất cả các phần tử khác đều bằng 0. Kích thước của ma trận đơn vị n x n là gì?",3) ,
        ("Trong đại số tuyến tính, ma trận chuyển vị của một ma trận là gì?",3) ,
        ("Trong đại số tuyến tính, một ma trận vuông có đường chéo chính là một vector với tất cả các phần tử đều bằng số thực dương. Ma trận này được gọi là gì?",3)
;


create table Answer(
	AnsID int primary key auto_increment,
    Detail varchar(100) ,
    isCorrect bool ,
    QuesID int ,
    foreign key(QuesID) references Question(QuesID)
);
insert into Answer(Detail,isCorrect,QuesID)
value 	("121",false,1) ,
		("18",false,1) ,
        ("25",false,1) ,
        ("11",true,1) ,
        ("3",false,2) ,
        ("125",false,2) ,
        ("7",true,2) ,
        ("7 và 11",true,3) ,
        ("8 và 24",false,3) ,
        ("9 và 15",false,3) ,
        ("True và False",false,4) ,
        ("0 và 1",true,4) ,
		("Positive và Negative",false,4) ,
        ("On và Off",false,4) ,
        ("True",false,5) ,
        ("False",true,5) ,
        ("NULL",false,5) ,
        ("Undefined",false,5) ,
        ("A+B",true,6) ,
        ("A*B",false,6) ,
        ("A-B",false,6) ,
        ("A^B",false,6) ,
        ("n x n",true,7) ,
        ("n x 1",false,7) ,
        ("1 x n",false,7) ,
        ("0 x n",false,7) ,
        ("Ma trận có tất cả các phần tử là 0",false,8) ,
        ("Ma trận có các phần tử giống nhau trên đường chéo chính",false,8) ,
        ("Ma trận với các dòng của nó được đổi thành cột và ngược lại",true,8) ,
        ("Ma trận với các dòng của nó được sắp xếp theo thứ tự tăng dần",false,8) ,
        ("Ma trận đơn vị",true,9) ,
        ("Ma trận đối xứng",false,9) ,
        ("Ma trận đường chéo",false,9) ,
        ("Ma trận tam giác trên",false,9) 
;

create table Result(
	TestID int ,
    NumberCorrect int ,
    TimeDone TIME ,
    Attempt int ,
    StudentID int ,
    primary key(TestID,Attempt,StudentID) ,
    foreign key(StudentID) references User(UID) ,
    foreign key(TestID) references Test(TestID)
);
insert into Result(TestID,NumberCorrect,TimeDone,Attempt,StudentID)
value 	(1,4,"0:9:52",1,21) ,
		(1,5,"0:4:52",2,21) ,
        (1,3,"0:9:52",1,16) ,
        (2,4,"0:10:00",1,16) ,
        (3,5,"0:8:12",1,16) ,
        (3,5,"0:10:00",1,14) 
;

