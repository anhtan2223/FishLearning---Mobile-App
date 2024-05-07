package com.example.fish.Untils

object DemoData {
    val UserInfo = User(
        "1" ,
        "Lê Sỹ Anh Tấn" ,
        "anhtan3332@gmail.com" ,
        "anhtan2223" ,
        "123" ,
        1
    )

    val ListUserPush = listOf<User>(
        User(
            "~" ,
            "Tạ Hồng Thư","day2@gmail.com","day2","12345678",
            2
        ) ,
        User(
            "~" ,
            "Dương Ngọc Quế","day5@gmail.com","day5","12345678",
            2
        ) ,
        User(
            "~" ,
            "Hồ Gia Bảo","day4@gmail.com","day4","12345678",
            2
        ) ,
        User(
            "~" ,
            "Đỗ An Nam","day6@gmail.com","day6","12345678",
            2
        ) ,
        User(
            "~" ,
            "Lý Phi Ðiệp","hoc1@gmail.com","hoc1","12345678",
            3
        ) ,
        User(
            "~" ,
            "Nghiêm Cát Uy","hoc2@gmail.com","hoc2","12345678",
            3
        ) ,
        User(
            "~" ,
            "Phí Trung Nhân","hoc3@gmail.com","hoc3","12345678",
            3
        ) ,
        User(
            "~" ,
            "Liều Ðình Na","hoc4@gmail.com","hoc4","12345678",
            3
        ) ,
        User(
            "~" ,
            "Đặng Bảo Thái","hoc5@gmail.com","hoc5","12345678",
            3
        ) ,
        User(
            "~" ,
            "Đỗ Phương Nam","hoc6@gmail.com","hoc6","12345678",
            3
        ) ,
        User(
            "~" ,
            "Mạc Minh Nhân","hoc7@gmail.com","hoc7","12345678",
            3
        ) ,
        User(
            "~" ,
            "Phạm Đăng Quang","hoc8@gmail.com","hoc8","12345678",
            3
        ) ,
        User(
            "~" ,
            "Doãn Minh Vương","hoc9@gmail.com","hoc9","12345678",
            3
        ) ,
        User(
            "~" ,
            "Huỳnh Hưng Ðạo","hoc10@gmail.com","hoc10","12345678",
            3
        ) ,
    )
    val ListUser = mutableListOf<User>(
        User(
            "admin" ,
            "Admin" , "admin@gmail.com" , "admin" , "123" ,
            1
        ) ,
        User(
            "teacher" ,
            "Giáo Viên" , "teacher@gmail.com" , "teacher" , "123" ,
            2
        ) ,
        User(
            "user" ,
            "Lê Sỹ Anh Tấn" , "user@gmail.com" , "user" , "123" ,
            3
        ) ,
        User(
            "teacher1" ,
            "Huỳnh Ngọc Thái Anh" , "hntanh@gmail.com" , "teacher1" , "12345678" ,
            2
        ) ,
        User(
            "teacher2" ,
            "Lý Ðắc Trọng" , "ldt@gmail.com" , "teacher2" , "12345678" ,
            2
        ) ,
        User(
            "teacher3" ,
            "Hoàng Chí Thanh" , "htcthanh@gmail.com" , "teacher3" , "12345678" ,
            2
        ) ,
        User(
            "teacher4" ,
            "Nguyễn Tuấn Việt" , "ntviet@gmail.com" , "teacher4" , "12345678" ,
            2
        ) ,
        User(
            "teacher5" ,
            "Bạch Ðức Hải" , "bdhai@gmail.com" , "teacher5" , "12345678" ,
            2
        ) ,
        User(
            "student1" ,
            "Lê Sỹ Anh Tấn" ,
            "anhtan3332@gmail.com" ,
            "lsatan" ,
            "12345678" ,
            3
        ) ,
        User(
            "student2" ,
            "Vũ Huy Lĩnh" ,
            "chlinh@gmail.com" ,
            "vhlinh" ,
            "12345678" ,
            3
        ) ,
        User(
            "student3" ,
            "Bùi Huyền Trân" ,
            "bhtran@gmail.com" ,
            "bhtran" ,
            "12345678" ,
            3
        ) ,
        User(
            "student4" ,
            "Phó Cát Uy" ,
            "pcuy@gmail.com" ,
            "pcuy" ,
            "12345678" ,
            3
        ) ,
        User(
            "student5" ,
            "Tạ Minh Triệu" ,
            "tmtrieu@gmail.com" ,
            "tmtrieu" ,
            "12345678" ,
            3
        ) ,
        User(
            "student6" ,
            "Võ Hương Thu" ,
            "vhthu@gmail.com" ,
            "vhthu" ,
            "12345678" ,
            3
        ) ,
        User(
            "student7" ,
            "Mai Lê Quỳnh" ,
            "mlquynh@gmail.com" ,
            "mlquynh" ,
            "12345678" ,
            3
        ) ,
        User(
            "student8" ,
            "Huỳnh Nhật Huy" ,
            "hnhuy@gmail.com" ,
            "hnhuy" ,
            "12345678" ,
            3
        ) ,
        User(
            "student9" ,
            "Huỳnh Bảo Thái" ,
            "hbthai@gmail.com" ,
            "hbthai" ,
            "12345678" ,
            3
        ) ,
        User(
            "student10" ,
            "Vũ Hoàng Khang" ,
            "vhkhang@gmail.com" ,
            "vhkhang" ,
            "12345678" ,
            3
        ) ,
        User(
            "student5" ,
            "Tạ Minh Triệu" ,
            "tmtrieu@gmail.com" ,
            "tmtrieu" ,
            "12345678" ,
            3
        ) ,
    )
    val ListClass = listOf<Class>(
        Class(
            "1",
            "Cybersecurity Fundamentals" ,
            "Nam 2023-2024" ,
            "teacher" ,
            "10/2/2023"
        ) ,
        Class(
            "2",
            "Machine Learning" ,
            "HK2 - Nam Hoc 2023-2024" ,
            "teacher3",
            "15/2/2023"
        ) ,
        Class(
            "3",
            "OOP" ,
            "Nam 2023-2024" ,
            "teacher4",
            "20/2/2023"
        ) ,
        Class(
            "4",
            "Discrete Mathematics" ,
            "Toán Rời Rạc - 2023-2024" ,
            "teacher",
            "25/2/2023"
        ) ,
        Class(
            "5",
            "Graph Theory" ,
            "Nam 2023-2024" ,
            "teacher5",
            "1/3/2023"
        ) ,
        Class(
            "6",
            "Big Data Analytics" ,
            "Niên Khoá 2023-2024" ,
            "teacher1",
            "2/3/2023"
        ) ,
        Class(
            "7",
            "Cloud Computing" ,
            "Học Kỳ 1 - Năm Học 2023-2024" ,
            "teacher3",
            "1/1/2023"
        ) ,
        Class(
            "8",
            "Data Visualization" ,
            "Niên Khoá Kỳ 1 Năm 2022-2023" ,
            "teacher4",
            "15/2/2023"
        ) ,
        Class(
            "9",
            "Game Development with Unity" ,
            "Nam 2023-2024" ,
            "teacher1",
            "12/2/2023"
        ) ,
        Class(
            "10",
            "Natural Language Processing" ,
            "Năm 2023-2024" ,
            "teacher3",
            "13/2/2023"
        ) ,
        Class(
            "11",
            "Digital Image Analysis" ,
            "Năm 2022-2023" ,
            "teacher2",
            "9/2/2023"
        ) ,
        Class(
            "12",
            "Internet of Things (IoT)" ,
            "Năm 2023-2024" ,
            "teacher4",
            "10/5/2023"
        ) ,
        Class(
            "13",
            "Speech Recognition" ,
            "Năm 2023-2024" ,
            "teacher1",
            "10/4/2023"
        ) ,
        Class(
            "14",
            "Computer Architecture" ,
            "Năm 2023-2024" ,
            "teacher3",
            "10/6/2023"
        ) ,
        Class(
            "15",
            "Biomedical Signal Processing" ,
            "Năm 2023-2024" ,
            "teacher2",
            "12/4/2023"
        ) ,
    )
    val ListEnrollment = listOf<Enrollment>(
        Enrollment("1" , "student1" , "24/5/2023") ,
        Enrollment("1" , "student2" , "24/5/2023") ,
        Enrollment("1" , "student3" , "24/5/2023") ,
        Enrollment("1" , "student4" , "24/5/2023") ,
        Enrollment("1" , "student5" , "24/5/2023") ,
        Enrollment("1" , "student8" , "24/5/2023") ,
        Enrollment("1" , "student9" , "24/5/2023") ,
        Enrollment("1" , "user" , "24/5/2023") ,

        Enrollment("2" , "student1" ) ,
        Enrollment("2" , "student3" ) ,
        Enrollment("2" , "student5" ) ,
        Enrollment("2" , "student6" ) ,
        Enrollment("2" , "student7" ) ,
        Enrollment("2" , "student8" ) ,

        Enrollment("3" , "student1" ) ,
        Enrollment("3" , "student2" ) ,
        Enrollment("3" , "student3" ) ,
        Enrollment("3" , "student4" ) ,
        Enrollment("3" , "student5" ) ,
        Enrollment("3" , "student6" ) ,
        Enrollment("3" , "student7" ) ,
        Enrollment("3" , "student8" ) ,
        Enrollment("3" , "student9" ) ,
        Enrollment("3" , "student10" ) ,
        Enrollment("3" , "user" ) ,


        Enrollment("4" , "student1" ) ,
        Enrollment("4" , "student2" ) ,
        Enrollment("4" , "student4" ) ,
        Enrollment("4" , "student7" ) ,
        Enrollment("4" , "student8" ) ,
        Enrollment("4" , "student9" ) ,
        Enrollment("4" , "student3" ) ,
        Enrollment("4" , "student10" ) ,
        Enrollment("4" , "user" ) ,

        Enrollment("5" , "student1" ) ,
        Enrollment("5" , "student2" ) ,
        Enrollment("5" , "student3" ) ,
        Enrollment("6" , "student2" ) ,
        Enrollment("6" , "student4" ) ,
        Enrollment("6" , "student5" ) ,

        Enrollment("7" , "student1" ) ,
        Enrollment("7" , "student2" ) ,
        Enrollment("7" , "student3" ) ,
        Enrollment("7" , "user" ) ,
        Enrollment("7" , "student5" ) ,

        Enrollment("8" , "student1" ) ,
        Enrollment("8" , "user" ) ,
        Enrollment("8" , "student3" ) ,
        Enrollment("8" , "student4" ) ,
        Enrollment("8" , "student5" ) ,

        Enrollment("9" , "student1" ) ,
        Enrollment("9" , "student2" ) ,
        Enrollment("9" , "student3" ) ,
        Enrollment("9" , "student4" ) ,
        Enrollment("9" , "user" ) ,

        Enrollment("10" , "student1" ) ,
        Enrollment("10" , "user" ) ,
        Enrollment("10" , "student3" ) ,
        Enrollment("10" , "student4" ) ,
        Enrollment("10" , "student5" ) ,

        Enrollment("11" , "student1" ) ,
        Enrollment("11" , "student2" ) ,

        Enrollment("12" , "student1" ) ,
        Enrollment("12" , "student3" ) ,
        Enrollment("12" , "student5" ) ,

        Enrollment("13" , "user" ) ,

        Enrollment("14" , "student3" ) ,

        Enrollment("15" , "student5" ) ,
    )
    val Topic = listOf<Topic>(
        Topic("1", "Introduction to Cybersecurity", "1"),
        Topic("2", "Network Security", "1"),
        Topic("3", "Cryptography", "1"),
        Topic("4", "Cyber Threats and Attacks", "1"),
        Topic("5", "Security Policies and Procedures", "1"),
        Topic("6", "Incident Response and Management", "1"),

        Topic("7", "Introduction to Machine Learning", "2"),
        Topic("8", "Supervised Learning", "2"),
        Topic("9", "Unsupervised Learning", "2"),
        Topic("10", "Machine Learning Algorithms", "2"),
        Topic("11", "Regression and Classification", "2"),
        Topic("12", "Neural Networks", "2"),

        Topic("13", "Introduction to Object-Oriented Programming", "3"),
        Topic("14", "Classes and Objects", "3"),
        Topic("15", "Inheritance and Polymorphism", "3"),
        Topic("16", "Encapsulation", "3"),
        Topic("17", "Abstraction", "3"),
        Topic("18", "Interfaces and Abstract Classes", "3"),

        Topic("46", "Introduction to Discrete Mathematics", "4"),
        Topic("47", "Logic and Propositional Calculus", "4"),
        Topic("48", "Sets and Relations", "4"),
        Topic("49", "Functions and Sequences", "4"),
        Topic("50", "Combinatorics", "4"),
        Topic("51", "Graph Theory", "4"),

    )

    val InsideTopic = listOf<Any>(
        TextBox("1", "Introduction to Cybersecurity", "1"),
        TextBox("2", "Basic principles of cryptography", "3"),
        TextBox("3", "Network Security Protocols", "2"),
        TextBox("4", "Cyber Threats: Types and Examples", "4"),
        TextBox("5", "Security Policies: Implementation and Enforcement", "5"),
        TextBox("6", "Incident Response Plan: Steps and Procedures", "6"),
        Document("7", "Introduction to Cybersecurity", "PDF", "1"),
        Document("8", "Network Security Basics", "PDF", "3"),
        Document("9", "Public Key Infrastructure (PKI) Explained", "PDF", "3"),
        Document("10", "Types of Cyber Threats", "PDF", "4"),
        Document("11", "Sample Security Policies", "PDF", "5"),
        Document("12", "Incident Response Plan Template", "PDF", "6"),
        Test("13", "Introduction to Cybersecurity Quiz", 2, 20, "1"),
        Test("14", "Network Security Test", 3, 30, "2"),

        TextBox("15", "Introduction to Machine Learning", "7"),
        TextBox("16", "Supervised Learning", "8"),
        TextBox("17", "Unsupervised Learning", "9"),
        TextBox("18", "Machine Learning Algorithms", "10"),
        TextBox("19", "Regression and Classification", "11"),
        TextBox("20", "Neural Networks", "12"),
        Document("21", "Introduction to Machine Learning", "PDF", "7"),
        Document("22", "Supervised Learning Techniques", "PDF", "8"),
        Document("23", "Unsupervised Learning Methods", "PDF", "9"),
        Document("24", "Machine Learning Algorithms Overview", "PDF", "10"),
        Document("25", "Regression Analysis in Machine Learning", "PDF", "11"),
        Document("26", "Neural Networks Fundamentals", "PDF", "12"),
        Test("27", "Introduction to Machine Learning Quiz", 5, 20, "7"),
        Test("28", "Supervised Learning Test", 5, 30, "8"),

        TextBox("29", "Introduction to Object-Oriented Programming", "13"),
        TextBox("30", "Understanding Classes and Objects", "14"),
        TextBox("31", "Inheritance and Polymorphism Concepts", "15"),
        TextBox("32", "Encapsulation in OOP", "16"),
        TextBox("33", "Abstraction and its Importance", "17"),
        TextBox("34", "Interfaces vs. Abstract Classes", "18"),
        Document("35", "Introduction to Object-Oriented Programming", "PDF", "13"),
        Document("36", "Classes and Objects Basics", "PDF", "14"),
        Document("37", "Inheritance and Polymorphism Overview", "PDF", "15"),
        Document("38", "Encapsulation Principles", "PDF", "16"),
        Document("39", "Abstraction Concepts Explained", "PDF", "17"),
        Test("40", "Introduction to OOP Quiz", 5, 20, "13"),
        Test("41", "Classes and Objects Test", 5, 30, "14"),
        Test("42", "Inheritance and Polymorphism Exam", 5, 40, "15"),
        Test("43", "Encapsulation Assessment", 5, 30, "16"),
        Test("44", "Abstraction Quiz", 5, 20, "17"),
        Test("45", "Interfaces vs. Abstract Classes Test", 5, 30, "18"),

        TextBox("46", "Introduction to Discrete Mathematics", "46"),
        TextBox("47", "Basic Logic and Propositional Calculus", "47"),
        TextBox("48", "Sets and Relations Explained", "48"),
        TextBox("49", "Functions and Sequences Overview", "49"),
        TextBox("50", "Fundamentals of Combinatorics", "50"),
        TextBox("51", "Introduction to Graph Theory", "51"),
        Document("52", "Introduction to Discrete Mathematics", "PDF", "46"),
        Document("53", "Logic and Propositional Calculus Basics", "PDF", "47"),
        Document("54", "Sets and Relations in Mathematics", "PDF", "48"),
        Document("55", "Functions and Sequences Handbook", "PDF", "49"),
        Document("56", "Combinatorics Fundamentals", "PDF", "50"),
        Document("57", "Graph Theory Primer", "PDF", "51"),
        Test("58", "Introduction to Discrete Mathematics Quiz", 5, 20, "46"),
        Test("59", "Logic and Propositional Calculus Test", 5, 30, "47"),
        Test("60", "Sets and Relations Exam", 5, 40, "48"),
        Test("61", "Functions and Sequences Assessment", 5, 30, "49"),
        Test("62", "Combinatorics Quiz", 5, 20, "50"),
        Test("63", "Graph Theory Test", 5, 30, "51"),
    )
    val QuestionList = listOf<Question>(
        Question("Q1", "Cybersecurity là gì?", "13") ,
        Question("Q2", "Phương thức bảo mật nào sau đây là phương thức không phù hợp?", "13") ,

        Question("Q3", "Phần mềm Firewall là gì?", "14"),
        Question("Q4", "SSL/TLS được sử dụng để làm gì?", "14"),
        Question("Q5", "Mục đích chính của mã hóa dữ liệu là gì?", "14") ,

        Question("Q6", "Trong lập trình hướng đối tượng, kế thừa là gì?", "40"),
        Question("Q7", "Đặc điểm chính của kế thừa là gì?", "40"),
        Question("Q8", "Trong Java, một lớp có thể kế thừa từ bao nhiêu lớp?", "40"),
        Question("Q9", "Trong kế thừa, lớp con có thể sử dụng được những thành phần nào của lớp cha?", "40"),
        Question("Q10", "Trong kế thừa, khi nào ta sử dụng từ khóa 'super'?", "40") ,

        Question("Q11", "Thuật ngữ 'Machine Learning' đề cập đến điều gì?", "27"),
        Question("Q12", "Supervised Learning là gì?", "27"),
        Question("Q13", "Unsupervised Learning là gì?", "27"),
        Question("Q14", "Trong Machine Learning, Bias là gì?", "27"),
        Question("Q15", "Vấn đề gặp phải thường xuyên trong quá trình huấn luyện mô hình Machine Learning là gì?", "27") ,

        Question("Q16", "Supervised Learning là gì?", "28"),
        Question("Q17", "Unsupervised Learning là gì?", "28"),
        Question("Q18", "Trong Machine Learning, Bias là gì?", "28"),
        Question("Q19", "Vấn đề gặp phải thường xuyên trong quá trình huấn luyện mô hình Machine Learning là gì?", "28"),
        Question("Q20", "Overfitting là gì?", "28") ,

        Question("Q21", "Discrete Mathematics nghiên cứu về cái gì?", "58"),
        Question("Q22", "Trong Discrete Mathematics, tập hợp là gì?", "58"),
        Question("Q23", "Trong Discrete Mathematics, định lý Pigeonhole là gì?", "58"),
        Question("Q24", "Trong Discrete Mathematics, tại sao tập hợp rỗng được gọi là tập hợp phi?", "58"),
        Question("Q25", "Trong Discrete Mathematics, một biểu thức hoạt động là gì?", "58") ,

        Question("Q26", "Logic và Calculus Dự đoán làm gì?", "59"),
        Question("Q27", "Propositional Calculus dựa trên điều gì?", "59"),
        Question("Q28", "Trong Logic, một phát biểu là gì?", "59"),
        Question("Q29", "Trong Logic, phép giao hoán là gì?", "59"),
        Question("Q30", "Trong Logic, phép phân tán là gì?", "59"),

        Question("Q31", "Tập hợp và quan hệ được nghiên cứu trong lĩnh vực nào?", "60"),
        Question("Q32", "Trong Discrete Mathematics, tập hợp được định nghĩa như thế nào?", "60"),
        Question("Q33", "Trong Discrete Mathematics, quan hệ là gì?", "60"),
        Question("Q34", "Trong Discrete Mathematics, quan hệ tương đương là gì?", "60"),
        Question("Q35", "Trong Discrete Mathematics, quan hệ đối xứng là gì?", "60")
    )
    val AnswerList = listOf<Answer>(
        Answer("A1", "Cybersecurity là việc bảo vệ hệ thống, mạng và chương trình khỏi các cuộc tấn công số.", true, "Q1") ,
        Answer("A2", "Cybersecurity liên quan đến việc bảo vệ môi trường.", false, "Q1") ,
        Answer("A3", "Cybersecurity chỉ tập trung vào việc bảo vệ mạng Internet.", false, "Q1") ,
        Answer("A4", "Cybersecurity không có liên quan gì đến dữ liệu.", false, "Q1") ,

        Answer("A5", "Sử dụng mật khẩu mạnh.", false, "Q2") ,
        Answer("A6", "Sử dụng chứng chỉ SSL/TLS.", false, "Q2") ,
        Answer("A7", "Tắt tường lửa.", true, "Q2") ,
        Answer("A8", "Sử dụng tường lửa.", false, "Q2") ,

        Answer("A9", "Phần mềm giúp tăng tốc độ Internet.", false, "Q3"),
        Answer("A10", "Phần mềm giúp tạo ra mạng lưới LAN.", false, "Q3"),
        Answer("A11", "Phần mềm giúp bảo vệ mạng khỏi các cuộc tấn công trực tuyến.", true, "Q3"),
        Answer("A12", "Phần mềm giúp tạo ra bản sao lưu của hệ thống.", false, "Q3"),

        Answer("A13", "Chia sẻ tệp tin qua mạng.", false, "Q4"),
        Answer("A14", "Bảo mật kết nối giữa trình duyệt và máy chủ.", true, "Q4"),
        Answer("A15", "Tạo ra tên miền mới.", false, "Q4"),
        Answer("A16", "Bảo vệ máy chủ khỏi virus.", false, "Q4"),

        Answer("A17", "Làm cho dữ liệu trở nên dễ đọc hơn.", false, "Q5"),
        Answer("A18", "Bảo vệ dữ liệu tránh khỏi truy cập trái phép.", true, "Q5"),
        Answer("A19", "Tạo ra nhiều bản sao của dữ liệu.", false, "Q5"),
        Answer("A20", "Tăng tốc độ truy cập vào dữ liệu.", false, "Q5") ,

        Answer("A21", "Kế thừa là khả năng một lớp con kế thừa tất cả các thuộc tính và phương thức của lớp cha.", true, "Q6"),
        Answer("A2", "Kế thừa là khả năng một lớp cha kế thừa tất cả các thuộc tính và phương thức của lớp con.", false, "Q6"),
        Answer("A23", "Kế thừa là khả năng một lớp có thể kế thừa từ nhiều lớp khác nhau.", false, "Q6"),
        Answer("A24", "Kế thừa là khả năng một lớp không thể kế thừa từ lớp khác.", false, "Q6"),

        Answer("A25", "Kế thừa cho phép tái sử dụng code và giảm sự phức tạp của chương trình.", true, "Q7"),
        Answer("A26", "Kế thừa cho phép một lớp con chia sẻ các thuộc tính và phương thức của lớp cha.", false, "Q7"),
        Answer("A27", "Kế thừa chỉ cho phép một lớp con sử dụng một phần của lớp cha.", false, "Q7"),
        Answer("A28", "Kế thừa chỉ áp dụng cho các ngôn ngữ lập trình cụ thể như Java.", false, "Q7"),

        Answer("A29", "Một lớp chỉ có thể kế thừa từ một lớp cha duy nhất.", false, "Q8"),
        Answer("A30", "Một lớp có thể kế thừa từ nhiều lớp khác nhau.", true, "Q8"),
        Answer("A31", "Một lớp không thể kế thừa từ lớp khác.", false, "Q8"),
        Answer("A32", "Một lớp có thể kế thừa từ bất kỳ lớp nào.", false, "Q8"),

        Answer("A33", "Lớp con chỉ có thể sử dụng các phương thức của lớp cha.", false, "Q9"),
        Answer("A34", "Lớp con chỉ có thể sử dụng các thuộc tính của lớp cha.", false, "Q9"),
        Answer("A35", "Lớp con có thể sử dụng cả thuộc tính và phương thức của lớp cha.", true, "Q9"),
        Answer("A36", "Lớp con không thể sử dụng bất kỳ thành phần nào của lớp cha.", false, "Q9"),

        Answer("A37", "Từ khóa 'super' được sử dụng để gọi một phương thức của lớp con.", false, "Q10"),
        Answer("A38", "Từ khóa 'super' được sử dụng để gọi một phương thức của lớp cha.", true, "Q10"),
        Answer("A39", "Từ khóa 'super' được sử dụng để gọi một phương thức của lớp cháu.", false, "Q10"),
        Answer("A40", "Từ khóa 'super' chỉ được sử dụng trong lớp cha.", false, "Q10") ,

        Answer("A41", "Thuật ngữ 'Machine Learning' ám chỉ việc máy tính có khả năng học hỏi từ dữ liệu mà không cần được lập trình cụ thể.", true, "Q11"),
        Answer("A42", "Thuật ngữ 'Machine Learning' chỉ đề cập đến việc máy tính sử dụng thuật toán tối ưu hóa.", false, "Q11"),
        Answer("A43", "Thuật ngữ 'Machine Learning' chỉ đơn giản là việc máy tính sử dụng dữ liệu để đưa ra dự đoán.", false, "Q11"),
        Answer("A44", "Thuật ngữ 'Machine Learning' chỉ đề cập đến việc máy tính tự động tạo ra các mô hình.", false, "Q11"),

        Answer("A45", "Supervised Learning là phương pháp học máy mà trong đó một tập hợp dữ liệu đã được gán nhãn được sử dụng để huấn luyện mô hình.", true, "Q12"),
        Answer("A46", "Supervised Learning là phương pháp học máy mà không có sự giám sát từ con người.", false, "Q12"),
        Answer("A47", "Supervised Learning là phương pháp học máy chỉ sử dụng dữ liệu không gán nhãn.", false, "Q12"),
        Answer("A48", "Supervised Learning là phương pháp học máy chỉ áp dụng cho bài toán phân loại.", false, "Q12"),

        Answer("A49", "Unsupervised Learning là phương pháp học máy mà trong đó không có sự giám sát từ con người.", true, "Q13"),
        Answer("A50", "Unsupervised Learning là phương pháp học máy mà không cần sử dụng dữ liệu.", false, "Q13"),
        Answer("A51", "Unsupervised Learning là phương pháp học máy mà chỉ sử dụng dữ liệu gán nhãn.", false, "Q13"),
        Answer("A52", "Unsupervised Learning là phương pháp học máy chỉ áp dụng cho bài toán phân loại.", false, "Q13"),

        Answer("A53", "Bias trong Machine Learning ám chỉ sự sai lệch giữa dự đoán của mô hình và giá trị thực tế.", true, "Q14"),
        Answer("A54", "Bias trong Machine Learning là tỉ lệ số lượng mẫu dữ liệu được dùng cho việc kiểm tra và huấn luyện.", false, "Q14"),
        Answer("A55", "Bias trong Machine Learning ám chỉ sự thiên vị của mô hình về phía các lớp quan trọng hơn.", false, "Q14"),
        Answer("A56", "Bias trong Machine Learning ám chỉ sự khả năng của mô hình để tự động học từ dữ liệu.", false, "Q14"),

        Answer("A57", "Overfitting là vấn đề gặp phải khi mô hình Machine Learning quá mức khớp với dữ liệu huấn luyện, dẫn đến hiệu suất kém trên dữ liệu mới.", true, "Q15"),
        Answer("A58", "Underfitting là vấn đề gặp phải khi mô hình Machine Learning quá mức đơn giản, không thể học được các mẫu phức tạp trong dữ liệu.", false, "Q15"),
        Answer("A59", "Noise là vấn đề gặp phải khi dữ liệu không thể biểu diễn một cách chính xác các quan hệ trong dữ liệu thực tế.", false, "Q15"),
        Answer("A60", "Chỉ số Accuracy là một thước đo đánh giá hiệu suất của mô hình Machine Learning trên dữ liệu kiểm tra.", false, "Q15") ,

        Answer("A61", "Supervised Learning là phương pháp học máy mà trong đó một tập hợp dữ liệu đã được gán nhãn được sử dụng để huấn luyện mô hình.", true, "Q16"),
        Answer("A62", "Supervised Learning là phương pháp học máy mà không có sự giám sát từ con người.", false, "Q16"),
        Answer("A63", "Supervised Learning là phương pháp học máy chỉ sử dụng dữ liệu không gán nhãn.", false, "Q16"),
        Answer("A64", "Supervised Learning là phương pháp học máy chỉ áp dụng cho bài toán phân loại.", false, "Q16"),

        Answer("A65", "Unsupervised Learning là phương pháp học máy mà trong đó không có sự giám sát từ con người.", true, "Q17"),
        Answer("A66", "Unsupervised Learning là phương pháp học máy mà không cần sử dụng dữ liệu.", false, "Q17"),
        Answer("A67", "Unsupervised Learning là phương pháp học máy mà chỉ sử dụng dữ liệu gán nhãn.", false, "Q17"),
        Answer("A68", "Unsupervised Learning là phương pháp học máy mà chỉ áp dụng cho bài toán phân loại.", false, "Q17"),

        Answer("A69", "Bias trong Machine Learning ám chỉ sự sai lệch giữa dự đoán của mô hình và giá trị thực tế.", true, "Q18"),
        Answer("A70", "Bias trong Machine Learning là tỉ lệ số lượng mẫu dữ liệu được dùng cho việc kiểm tra và huấn luyện.", false, "Q18"),
        Answer("A71", "Bias trong Machine Learning ám chỉ sự thiên vị của mô hình về phía các lớp quan trọng hơn.", false, "Q18"),
        Answer("A72", "Bias trong Machine Learning ám chỉ sự khả năng của mô hình để tự động học từ dữ liệu.", false, "Q18"),

        Answer("A73", "Vấn đề gặp phải khi mô hình Machine Learning quá mức khớp với dữ liệu huấn luyện, dẫn đến hiệu suất kém trên dữ liệu mới là Overfitting.", true, "Q19"),
        Answer("A74", "Underfitting là vấn đề gặp phải khi mô hình Machine Learning quá mức đơn giản, không thể học được các mẫu phức tạp trong dữ liệu.", false, "Q19"),
        Answer("A75", "Noise là vấn đề gặp phải khi dữ liệu không thể biểu diễn một cách chính xác các quan hệ trong dữ liệu thực tế.", false, "Q19"),
        Answer("A76", "Chỉ số Accuracy là một thước đo đánh giá hiệu suất của mô hình Machine Learning trên dữ liệu kiểm tra.", false, "Q19"),

        Answer("A77", "Overfitting là vấn đề gặp phải khi mô hình Machine Learning quá mức khớp với dữ liệu huấn luyện, dẫn đến hiệu suất kém trên dữ liệu mới.", true, "Q20"),
        Answer("A78", "Underfitting là vấn đề gặp phải khi mô hình Machine Learning quá mức đơn giản, không thể học được các mẫu phức tạp trong dữ liệu.", false, "Q20"),
        Answer("A79", "Noise là vấn đề gặp phải khi dữ liệu không thể biểu diễn một cách chính xác các quan hệ trong dữ liệu thực tế.", false, "Q20"),
        Answer("A80", "Chỉ số Accuracy là một thước đo đánh giá hiệu suất của mô hình Machine Learning trên dữ liệu kiểm tra.", false, "Q20") ,


        Answer("A81", "Discrete Mathematics nghiên cứu về các đối tượng không liên tục và không giới hạn.", true, "Q21"),
        Answer("A82", "Discrete Mathematics nghiên cứu về các đối tượng liên tục và vô hạn.", false, "Q21"),
        Answer("A83", "Discrete Mathematics nghiên cứu về các hàm số liên tục.", false, "Q21"),
        Answer("A84", "Discrete Mathematics nghiên cứu về các phương trình vi phân.", false, "Q21"),

        Answer("A85", "Trong Discrete Mathematics, tập hợp là một tập hợp các phần tử được tổ chức hoặc xác định theo một quy tắc nhất định.", true, "Q22"),
        Answer("A86", "Trong Discrete Mathematics, tập hợp là một tập hợp các số thực.", false, "Q22"),
        Answer("A87", "Trong Discrete Mathematics, tập hợp là một tập hợp các số nguyên.", false, "Q22"),
        Answer("A88", "Trong Discrete Mathematics, tập hợp là một tập hợp các số phức.", false, "Q22"),

        Answer("A89", "Trong Discrete Mathematics, định lý Pigeonhole là một nguyên lý trong lý thuyết số khẳng định rằng nếu n chiếc quả được đặt trong m khe (n > m), thì ít nhất một khe phải chứa hai hoặc nhiều hơn quả.", true, "Q23"),
        Answer("A90", "Trong Discrete Mathematics, định lý Pigeonhole là một nguyên lý trong lý thuyết số khẳng định rằng nếu n chiếc quả được đặt trong m khe (n < m), thì ít nhất một khe phải chứa hai hoặc nhiều hơn quả.", false, "Q23"),
        Answer("A91", "Trong Discrete Mathematics, định lý Pigeonhole là một nguyên lý trong lý thuyết tập hợp khẳng định rằng tập hợp không thể rỗng.", false, "Q23"),
        Answer("A92", "Trong Discrete Mathematics, định lý Pigeonhole là một nguyên lý trong lý thuyết tập hợp khẳng định rằng tập hợp có thể chứa tất cả các phần tử.", false, "Q23"),

        Answer("A93", "Tập hợp rỗng được gọi là tập hợp phi vì không chứa bất kỳ phần tử nào.", true, "Q24"),
        Answer("A94", "Tập hợp rỗng được gọi là tập hợp phi vì chứa một phần tử duy nhất là 0.", false, "Q24"),
        Answer("A95", "Tập hợp rỗng được gọi là tập hợp phi vì chứa vô số phần tử.", false, "Q24"),
        Answer("A96", "Tập hợp rỗng được gọi là tập hợp phi vì chứa một phần tử không xác định.", false, "Q24"),

        Answer("A97", "Một biểu thức hoạt động là một biểu thức toán học hoặc logic được sử dụng để thể hiện một quy tắc hoặc quan hệ giữa các phần tử của một tập hợp.", true, "Q25"),
        Answer("A98", "Một biểu thức hoạt động là một biểu thức chỉ gồm toán tử và không có toán hạng.", false, "Q25"),
        Answer("A99", "Một biểu thức hoạt động là một biểu thức chỉ gồm toán hạng và không có toán tử.", false, "Q25"),
        Answer("A100", "Một biểu thức hoạt động là một biểu thức chỉ gồm toán tử nhưng không có toán hạng.", false, "Q25") ,

        Answer("A101", "Logic và Calculus Dự đoán kết quả của các quá trình dựa trên quy tắc logic.", true, "Q26"),
        Answer("A102", "Logic và Calculus Dự đoán kết quả của các quá trình dựa trên quy tắc toán học.", false, "Q26"),
        Answer("A103", "Logic và Calculus Dự đoán kết quả của các quá trình dựa trên quy tắc vật lý.", false, "Q26"),
        Answer("A104", "Logic và Calculus Dự đoán kết quả của các quá trình dựa trên quy tắc văn hóa.", false, "Q26"),

        Answer("A105", "Propositional Calculus dựa trên việc phân tích và xử lý các phát biểu đúng/sai (propositions).", true, "Q27"),
        Answer("A106", "Propositional Calculus dựa trên việc phân tích và xử lý các phát biểu logic (logic statements).", false, "Q27"),
        Answer("A107", "Propositional Calculus dựa trên việc phân tích và xử lý các phát biểu toán học (mathematical statements).", false, "Q27"),
        Answer("A108", "Propositional Calculus dựa trên việc phân tích và xử lý các phát biểu văn hóa (cultural statements).", false, "Q27"),

        Answer("A109", "Trong Logic, một phát biểu là một câu khẳng định có thể được đánh giá là đúng hoặc sai.", true, "Q28"),
        Answer("A110", "Trong Logic, một phát biểu là một câu hỏi có thể được trả lời bằng đúng hoặc sai.", false, "Q28"),
        Answer("A111", "Trong Logic, một phát biểu là một câu trả lời có thể được đánh giá là đúng hoặc sai.", false, "Q28"),
        Answer("A112", "Trong Logic, một phát biểu là một câu hỏi có thể được trả lời bằng có hoặc không.", false, "Q28"),

        Answer("A113", "Phép giao hoán là một phép biến đổi mà thay đổi vị trí của hai toán hạng mà không làm thay đổi giá trị của biểu thức.", true, "Q29"),
        Answer("A114", "Phép giao hoán là một phép biến đổi mà thay đổi giá trị của hai toán hạng mà không làm thay đổi vị trí của chúng.", false, "Q29"),
        Answer("A115", "Phép giao hoán là một phép biến đổi mà không làm thay đổi giá trị của hai toán hạng hoặc vị trí của chúng.", false, "Q29"),
        Answer("A116", "Phép giao hoán là một phép biến đổi mà không làm thay đổi giá trị của biểu thức.", false, "Q29"),

        Answer("A117", "Phép phân tán là một phép biến đổi mà phân tán một toán hạng hoặc một nhóm toán hạng qua một phép toán khác.", true, "Q30"),
        Answer("A118", "Phép phân tán là một phép biến đổi mà tập hợp các toán hạng không thay đổi khi thực hiện phép toán đó.", false, "Q30"),
        Answer("A119", "Phép phân tán là một phép biến đổi mà kết quả cuối cùng không thay đổi khi thực hiện phép toán đó.", false, "Q30"),
        Answer("A120", "Phép phân tán là một phép biến đổi mà không làm thay đổi giá trị của biểu thức.", false, "Q30"),

        Answer("A121", "Tập hợp và quan hệ được nghiên cứu trong lĩnh vực lý thuyết tập hợp và lý thuyết quan hệ.", true, "Q31"),
        Answer("A122", "Tập hợp và quan hệ được nghiên cứu trong lĩnh vực toán học cổ điển.", false, "Q31"),
        Answer("A123", "Tập hợp và quan hệ được nghiên cứu trong lĩnh vực lý thuyết số.", false, "Q31"),
        Answer("A124", "Tập hợp và quan hệ được nghiên cứu trong lĩnh vực lý thuyết tổ hợp.", false, "Q31"),

        Answer("A125", "Trong Discrete Mathematics, tập hợp là một tập hợp các phần tử không có sự sắp xếp.", true, "Q32"),
        Answer("A126", "Trong Discrete Mathematics, tập hợp là một tập hợp các phần tử được sắp xếp theo thứ tự tăng dần.", false, "Q32"),
        Answer("A127", "Trong Discrete Mathematics, tập hợp là một tập hợp các phần tử được sắp xếp theo thứ tự giảm dần.", false, "Q32"),
        Answer("A128", "Trong Discrete Mathematics, tập hợp là một tập hợp các phần tử được sắp xếp theo một quy tắc nhất định.", false, "Q32"),

        Answer("A129", "Trong Discrete Mathematics, quan hệ là một tập hợp các phần tử có thứ tự cụ thể.", false, "Q33"),
        Answer("A130", "Trong Discrete Mathematics, quan hệ là một mối quan hệ giữa các phần tử của tập hợp.", true, "Q33"),
        Answer("A131", "Trong Discrete Mathematics, quan hệ là một tập hợp các phần tử không có thứ tự cụ thể.", false, "Q33"),
        Answer("A132", "Trong Discrete Mathematics, quan hệ là một tập hợp các phần tử có thứ tự ngẫu nhiên.", false, "Q33"),

        Answer("A133", "Trong Discrete Mathematics, quan hệ tương đương là một quan hệ đối xứng và có tính luỹ đa thức.", true, "Q34"),
        Answer("A134", "Trong Discrete Mathematics, quan hệ tương đương là một quan hệ đối xứng và không có tính luỹ đa thức.", false, "Q34"),
        Answer("A135", "Trong Discrete Mathematics, quan hệ tương đương là một quan hệ không đối xứng và có tính luỹ đa thức.", false, "Q34"),
        Answer("A136", "Trong Discrete Mathematics, quan hệ tương đương là một quan hệ không đối xứng và không có tính luỹ đa thức.", false, "Q34"),

        Answer("A137", "Trong Discrete Mathematics, quan hệ đối xứng là một quan hệ có tính chất xác định lại khi hoán vị hai phần tử.", true, "Q35"),
        Answer("A138", "Trong Discrete Mathematics, quan hệ đối xứng là một quan hệ không có tính chất xác định lại khi hoán vị hai phần tử.", false, "Q35"),
        Answer("A139", "Trong Discrete Mathematics, quan hệ đối xứng là một quan hệ không đối xứng.", false, "Q35"),
        Answer("A140", "Trong Discrete Mathematics, quan hệ đối xứng là một quan hệ có tính chất xác định lại khi thay đổi hai phần tử.", false, "Q35") ,

    )
//    val InsideTopic = listOf<Any>()

}