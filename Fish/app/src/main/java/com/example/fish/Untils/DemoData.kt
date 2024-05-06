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

//        Topic("1", "Chủ Đề Số 1" , ) ,
//        Topic("2", "Chủ Đề 2" , ) ,
//        Topic("3", "Chủ Đề Số 3" , ) ,
//        Topic("4", "Chủ Đề 4", ) ,
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
        Test("13", "Introduction to Cybersecurity Quiz", 10, 20, "1"),
        Test("14", "Network Security Test", 15, 30, "2"),

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
        Test("27", "Introduction to Machine Learning Quiz", 10, 20, "7"),
        Test("28", "Supervised Learning Test", 15, 30, "8"),

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
        Test("40", "Introduction to OOP Quiz", 10, 20, "13"),
        Test("41", "Classes and Objects Test", 15, 30, "14"),
        Test("42", "Inheritance and Polymorphism Exam", 20, 40, "15"),
        Test("43", "Encapsulation Assessment", 15, 30, "16"),
        Test("44", "Abstraction Quiz", 10, 20, "17"),
        Test("45", "Interfaces vs. Abstract Classes Test", 15, 30, "18"),

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
        Test("58", "Introduction to Discrete Mathematics Quiz", 10, 20, "46"),
        Test("59", "Logic and Propositional Calculus Test", 15, 30, "47"),
        Test("60", "Sets and Relations Exam", 20, 40, "48"),
        Test("61", "Functions and Sequences Assessment", 15, 30, "49"),
        Test("62", "Combinatorics Quiz", 10, 20, "50"),
        Test("63", "Graph Theory Test", 15, 30, "51"),
    )
    val QuestionList = listOf<Question>(
        Question(
            "0" ,
            "Ví Dụ Của Một Câu Hỏi" ,
            "0"
        ) ,
        Question(
            "1" ,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Te enim iudicem aequum puto, modo quae dicat ille bene noris. Apparet statim, quae sint officia, quae actiones" ,
            "2"
        ) ,
        Question(
            "2" ,
            "Con Cá Có Mấy Tay" ,
            "0"
        ) ,
        Question(
            "3" ,
            "Con Cá Có Mấy Mắt" ,
            "0"
        ) ,
        Question(
            "4" ,
            "Con Cá Có Mấy Mắt" ,
            "0"
        ) ,
        Question(
            "5" ,
            "Con Cá " ,
            "0"
        ) ,
        Question(
            "6" ,
            "Con Cá " ,
            "0"
        ) ,
    )
    val AnswerList = listOf<Answer>(
        Answer(
            "0" ,
            "Câu Trả Lời Đúng" ,
            true ,
            "0"
        ) ,
        Answer(
            "1" ,
            "Câu Trả Lời Sẽ Như Thế Này" ,
            false ,
            "0"
        ) ,
        Answer(
            "2" ,
            "Câu Trả Lời Sai" ,
            false ,
            "0"
        ) ,
        Answer(
            "3" ,
            "Và Có Thể Có Số Lượng Câu Trả Lời Đúng Và Sai Là Tuỳ Ý" ,
            false ,
            "0"
        ) ,
        Answer(
            "4" ,
            "0" ,
            true ,
            "1"
        ) ,
        Answer(
            "5" ,
            "1" ,
            false ,
            "1"
        ) ,
        Answer(
            "6" ,
            "2" ,
            false ,
            "1"
        ) ,
        Answer(
            "7" ,
            "3" ,
            false ,
            "1"
        ) ,
        Answer(
            "8" ,
            "0" ,
            true ,
            "2"
        ) ,
        Answer(
            "9" ,
            "1" ,
            false ,
            "2"
        ) ,
        Answer(
            "10" ,
            "2" ,
            false ,
            "2"
        ) ,
        Answer(
            "11" ,
            "3" ,
            false ,
            "2"
        ) ,
        Answer(
            "12" ,
            "0" ,
            false ,
            "3"
        ) ,
        Answer(
            "13" ,
            "1" ,
            false ,
            "3"
        ) ,
        Answer(
            "14" ,
            "2" ,
            false ,
            "3"
        ) ,
        Answer(
            "15" ,
            "3" ,
            true ,
            "3"
        ) ,
        Answer(
            "16" ,
            "4" ,
            false ,
            "3"
        ) ,
        Answer(
            "17" ,
            "5" ,
            false ,
            "3"
        ) ,
        Answer(
            "18" ,
            "3" ,
            false ,
            "3"
        ),
        Answer(
            "19" ,
            "0" ,
            false ,
            "4"
        ) ,
        Answer(
            "20" ,
            "1" ,
            false ,
            "4"
        ) ,
        Answer(
            "21" ,
            "2" ,
            true ,
            "4"
        ) ,
        Answer(
            "22" ,
            "3" ,
            false ,
            "4"
        ) ,
        Answer(
            "23" ,
            "0" ,
            false ,
            "5"
        ) ,
        Answer(
            "24" ,
            "1" ,
            false ,
            "5"
        ) ,
        Answer(
            "25" ,
            "2" ,
            true ,
            "5"
        ) ,
        Answer(
            "26" ,
            "3" ,
            false ,
            "5"
        ) ,
        Answer(
            "27" ,
            "0" ,
            false ,
            "6"
        ) ,
        Answer(
            "28" ,
            "1" ,
            false ,
            "6"
        ) ,
        Answer(
            "29" ,
            "2" ,
            true ,
            "6"
        ) ,
        Answer(
            "30" ,
            "3" ,
            false ,
            "6"
        )
    )
//    val InsideTopic = listOf<Any>()

}