-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 17, 2025 lúc 02:03 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltttienganh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblcauhoithithu`
--

CREATE TABLE `tblcauhoithithu` (
  `MaCauHoi` int(11) NOT NULL,
  `NoiDung` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DapAnA` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DapAnB` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DapAnC` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DapAnD` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DapAnDung` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DoKho` tinyint(4) DEFAULT 1 COMMENT '1: Dễ, 2: Trung bình, 3: Khó',
  `KyNang` enum('Listening','Reading','Grammar','Vocabulary') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaDoan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblcauhoithithu`
--

INSERT INTO `tblcauhoithithu` (`MaCauHoi`, `NoiDung`, `DapAnA`, `DapAnB`, `DapAnC`, `DapAnD`, `DapAnDung`, `DoKho`, `KyNang`, `MaDoan`) VALUES
(1, 'Choose the word that has the underlined part pronounced differently:', 'cat', 'car', 'city', 'cup', 'C', 1, 'Vocabulary', NULL),
(2, 'Which word means \"a building where people live\"?', 'hospital', 'school', 'house', 'office', 'C', 1, 'Vocabulary', NULL),
(3, 'What is the past tense of \"go\"?', 'goed', 'went', 'gone', 'goes', 'B', 1, 'Grammar', NULL),
(4, 'She _____ to school every day.', 'go', 'goes', 'going', 'gone', 'B', 1, 'Grammar', NULL),
(5, 'Which sentence is correct?', 'He can to swim.', 'He can swims.', 'He can swim.', 'He can swimming.', 'C', 2, 'Grammar', NULL),
(6, 'Choose the correct spelling:', 'Accomodate', 'Acommodate', 'Accommodate', 'Acomodate', 'C', 2, 'Vocabulary', NULL),
(7, 'What is the opposite of \"happy\"?', 'Sad', 'Angry', 'Excited', 'Tired', 'A', 1, 'Vocabulary', NULL),
(8, 'If I _____ rich, I would travel the world.', 'am', 'was', 'were', 'be', 'C', 3, 'Grammar', NULL),
(9, 'The capital of Australia is _____.', 'Sydney', 'Melbourne', 'Canberra', 'Perth', 'C', 2, 'Reading', NULL),
(10, 'She suggested _____ to the cinema.', 'to go', 'going', 'go', 'gone', 'B', 3, 'Grammar', NULL),
(11, 'Where was coffee first discovered?', 'Brazil', 'Ethiopia', 'Vietnam', 'Colombia', 'B', 1, 'Reading', 1),
(12, 'Who noticed the effects of coffee berries first?', 'A farmer', 'A goat herder', 'A scientist', 'A merchant', 'B', 1, 'Reading', 1),
(13, 'When did coffee spread to Europe?', '12th century', '15th century', '17th century', '19th century', 'C', 2, 'Reading', 1),
(14, 'What is the main idea of the passage?', 'Different types of coffee', 'The health effects of coffee', 'The history of coffee', 'How to grow coffee', 'C', 2, 'Reading', 1),
(15, 'Why is the library closed?', 'For a holiday', 'For renovations', 'For staff training', 'For cleaning', 'B', 1, 'Listening', 2),
(16, 'What should students do for urgent inquiries?', 'Visit the library', 'Call the librarian', 'Send an email', 'Wait until Monday', 'C', 1, 'Listening', 2),
(17, 'What effect did the coffee berries have on the goats?', 'They slept more', 'They became energetic', 'They got sick', 'They stopped eating', 'B', 1, 'Reading', 1),
(18, 'In which century was coffee being grown in the Arabian Peninsula?', '10th century', '13th century', '15th century', '18th century', 'C', 2, 'Reading', 1),
(19, 'The word \"beverages\" in the passage is closest in meaning to:', 'Foods', 'Drinks', 'Medicines', 'Plants', 'B', 2, 'Reading', 1),
(20, 'Which of the following is NOT mentioned about coffee?', 'Its origin', 'Its spread to Europe', 'Its preparation methods', 'Its popularity today', 'C', 3, 'Reading', 1),
(21, 'What can be inferred about coffee from the passage?', 'It was immediately popular worldwide', 'It spread gradually to different regions', 'It was first used as medicine', 'It was discovered by scientists', 'B', 3, 'Reading', 1),
(22, 'The legend of Kaldi is mentioned to illustrate:', 'How coffee was discovered', 'How coffee is grown', 'How coffee is prepared', 'How coffee affects animals', 'A', 2, 'Reading', 1),
(23, 'Until when are the due dates extended?', 'This Friday', 'This Sunday', 'Next Monday', 'Next Wednesday', 'C', 1, 'Listening', 2),
(24, 'What can students still access during the closure?', 'Physical books', 'Study rooms', 'Online resources', 'Library computers', 'C', 1, 'Listening', 2),
(25, 'The announcement is mainly about:', 'New library books', 'Library closure information', 'Library membership rules', 'Library opening hours', 'B', 2, 'Listening', 2),
(26, 'What should students do if they need immediate help?', 'Visit another library', 'Call the emergency number', 'Email the library', 'Wait until the library reopens', 'C', 2, 'Listening', 2),
(27, 'The word \"extended\" in the announcement is closest in meaning to:', 'Reduced', 'Cancelled', 'Postponed', 'Increased', 'C', 2, 'Listening', 2),
(28, 'What type of work is being done at the library?', 'Painting', 'Renovations', 'Cleaning', 'Expansion', 'B', 1, 'Listening', 2),
(29, 'Where can students find the library website?', 'The announcement doesn\'t say', 'On university posters', 'In their email', 'In the transcript', 'A', 3, 'Listening', 2),
(30, 'What is the tone of this announcement?', 'Apologetic', 'Informative', 'Humorous', 'Critical', 'B', 2, 'Listening', 2),
(31, 'What is the main topic of the passage?', 'Types of exercise equipment', 'Benefits of regular exercise', 'Exercise for children', 'Professional sports training', 'B', 1, 'Reading', 3),
(32, 'Exercise helps reduce the risk of which disease?', 'Diabetes only', 'Cardiovascular disease', 'Cancer only', 'Infectious diseases', 'B', 1, 'Reading', 3),
(33, 'How does exercise benefit mental health?', 'By increasing income', 'By reducing symptoms of depression and anxiety', 'By improving eyesight', 'By changing personality', 'B', 1, 'Reading', 3),
(34, 'How much exercise do adults need weekly?', '60 minutes', '100 minutes', '150 minutes', '200 minutes', 'C', 1, 'Reading', 3),
(35, 'Which activity is NOT mentioned as beneficial?', 'Brisk walking', 'Swimming', 'Weight lifting', 'Cycling', 'C', 2, 'Reading', 3),
(36, 'The word \"moderate-intensity\" is closest in meaning to:', 'Very hard', 'Medium level', 'Very easy', 'Competitive', 'B', 2, 'Reading', 3),
(37, 'What is described as key to long-term wellbeing?', 'Eating healthy food', 'Making exercise a regular habit', 'Getting enough sleep', 'Taking vitamins', 'B', 2, 'Reading', 3),
(38, 'Which benefit is NOT mentioned in the passage?', 'Weight control', 'Stronger bones and muscles', 'Better memory', 'Reduced anxiety', 'C', 3, 'Reading', 3),
(39, 'What can be inferred about exercise from the passage?', 'Only intense exercise is beneficial', 'It requires expensive equipment', 'Simple activities can be effective', 'It only helps physical health', 'C', 3, 'Reading', 3),
(40, 'The author\'s tone in this passage can be described as:', 'Critical', 'Humorous', 'Encouraging', 'Neutral', 'C', 2, 'Reading', 3),
(41, 'Which train is delayed?', 'The 14:00 to London', 'The 14:15 to Manchester', 'The 14:30 to Birmingham', 'The 14:45 to Liverpool', 'B', 1, 'Listening', 4),
(42, 'What is the reason for the delay?', 'Bad weather', 'Signaling problems', 'Staff shortage', 'Mechanical issues', 'B', 1, 'Listening', 4),
(43, 'How long is the delay expected to be?', '10 minutes', '20 minutes', '30 minutes', '1 hour', 'B', 1, 'Listening', 4),
(44, 'Where should Liverpool passengers go?', 'Platform 1', 'Platform 2', 'Platform 3', 'Platform 4', 'C', 1, 'Listening', 4),
(45, 'What is being offered to affected passengers?', 'Free tickets', 'Complimentary drinks', 'Food vouchers', 'Taxi service', 'B', 2, 'Listening', 4),
(46, 'Where can passengers get more information?', 'From the conductor', 'From information screens', 'From other passengers', 'From the café staff', 'B', 2, 'Listening', 4),
(47, 'The word \"complimentary\" is closest in meaning to:', 'Expensive', 'Free', 'Delicious', 'Required', 'B', 2, 'Listening', 4),
(48, 'What is the purpose of this announcement?', 'To advertise the café', 'To inform about a delay', 'To announce a sale', 'To introduce new staff', 'B', 2, 'Listening', 4),
(49, 'What can be inferred about the Liverpool train?', 'It is also delayed', 'It is ready to depart', 'It is cancelled', 'It is very crowded', 'B', 3, 'Listening', 4),
(50, 'The speaker\'s tone can be described as:', 'Angry', 'Apologetic', 'Excited', 'Bored', 'B', 2, 'Listening', 4),
(51, 'She _____ to school every morning.', 'go', 'goes', 'going', 'gone', 'B', 1, 'Grammar', NULL),
(52, 'They _____ playing football now.', 'is', 'are', 'am', 'be', 'B', 1, 'Grammar', NULL),
(53, 'I _____ a new car last month.', 'buy', 'buys', 'bought', 'buying', 'C', 1, 'Grammar', NULL),
(54, '_____ you like some coffee?', 'Do', 'Would', 'Are', 'Have', 'B', 1, 'Grammar', NULL),
(55, 'This is _____ book.', 'me', 'my', 'I', 'mine', 'B', 1, 'Grammar', NULL),
(56, 'If I _____ you, I would study harder.', 'am', 'was', 'were', 'be', 'C', 2, 'Grammar', NULL),
(57, 'She has been working here _____ 2010.', 'since', 'for', 'from', 'in', 'A', 2, 'Grammar', NULL),
(58, 'The test was _____ than I expected.', 'difficult', 'more difficult', 'most difficult', 'difficulter', 'B', 2, 'Grammar', NULL),
(59, 'By next year, I _____ my degree.', 'will finish', 'will have finished', 'finish', 'am finishing', 'B', 2, 'Grammar', NULL),
(60, 'He suggested _____ to the cinema.', 'to go', 'going', 'go', 'gone', 'B', 2, 'Grammar', NULL),
(61, 'Not only _____ late, but he also forgot his books.', 'he was', 'was he', 'he is', 'is he', 'B', 3, 'Grammar', NULL),
(62, 'Had I known about the problem, I _____ help.', 'would have', 'will', 'would', 'had', 'A', 3, 'Grammar', NULL),
(63, 'It\'s high time you _____ to bed.', 'go', 'went', 'have gone', 'will go', 'B', 3, 'Grammar', NULL),
(64, 'The harder you study, _____ results you get.', 'the best', 'the better', 'better', 'best', 'B', 3, 'Grammar', NULL),
(65, 'She _____ rather not attend the meeting.', 'would', 'should', 'could', 'might', 'A', 3, 'Grammar', NULL),
(66, 'By the time we arrived, the movie _____.', 'already starts', 'has already started', 'had already started', 'already starting', 'C', 2, 'Grammar', NULL),
(67, 'Neither John nor his friends _____ going to the party.', 'is', 'are', 'was', 'has', 'B', 2, 'Grammar', NULL),
(68, 'I wish I _____ how to swim when I was younger.', 'learn', 'learned', 'had learned', 'would learn', 'C', 3, 'Grammar', NULL),
(69, '_____ his illness, he came to the meeting.', 'Despite', 'Although', 'Because', 'Whereas', 'A', 2, 'Grammar', NULL),
(70, 'The report _____ by the committee right now.', 'is reviewed', 'is being reviewed', 'has reviewed', 'was reviewed', 'B', 2, 'Grammar', NULL),
(71, 'What is the opposite of \"happy\"?', 'Sad', 'Angry', 'Excited', 'Tired', 'A', 1, 'Vocabulary', NULL),
(72, 'A person who teaches is called a _____.', 'teacher', 'doctor', 'engineer', 'lawyer', 'A', 1, 'Vocabulary', NULL),
(73, 'What do you call a building where people live?', 'Hospital', 'School', 'House', 'Office', 'C', 1, 'Vocabulary', NULL),
(74, 'Which word means \"very big\"?', 'Small', 'Tiny', 'Huge', 'Short', 'C', 1, 'Vocabulary', NULL),
(75, 'What is the capital of France?', 'London', 'Berlin', 'Paris', 'Rome', 'C', 1, 'Vocabulary', NULL),
(76, 'The word \"benevolent\" means:', 'Strict', 'Kind', 'Angry', 'Funny', 'B', 2, 'Vocabulary', NULL),
(77, 'What does \"punctual\" mean?', 'On time', 'Late', 'Early', 'Busy', 'A', 2, 'Vocabulary', NULL),
(78, 'A synonym for \"intelligent\" is:', 'Smart', 'Strong', 'Tall', 'Fast', 'A', 2, 'Vocabulary', NULL),
(79, 'What does \"frugal\" mean?', 'Wasteful', 'Generous', 'Economical', 'Rich', 'C', 2, 'Vocabulary', NULL),
(80, 'The word \"ambiguous\" means:', 'Clear', 'Unclear', 'Important', 'Funny', 'B', 2, 'Vocabulary', NULL),
(81, 'What does \"ephemeral\" mean?', 'Lasting forever', 'Lasting a short time', 'Very large', 'Very small', 'B', 3, 'Vocabulary', NULL),
(82, 'A \"philanthropist\" is someone who:', 'Hates people', 'Loves money', 'Gives to charity', 'Studies plants', 'C', 3, 'Vocabulary', NULL),
(83, 'The word \"ubiquitous\" means:', 'Rare', 'Present everywhere', 'Expensive', 'Difficult', 'B', 3, 'Vocabulary', NULL),
(84, 'What does \"loquacious\" mean?', 'Quiet', 'Talkative', 'Angry', 'Happy', 'B', 3, 'Vocabulary', NULL),
(85, '\"Pragmatic\" means:', 'Idealistic', 'Practical', 'Theoretical', 'Artistic', 'B', 3, 'Vocabulary', NULL),
(86, 'Which word means \"to make worse\"?', 'Improve', 'Aggravate', 'Alleviate', 'Comfort', 'B', 2, 'Vocabulary', NULL),
(87, '\"Meticulous\" means:', 'Careless', 'Careful', 'Quick', 'Slow', 'B', 2, 'Vocabulary', NULL),
(88, 'What does \"verbose\" mean?', 'Using few words', 'Using too many words', 'Speaking clearly', 'Speaking loudly', 'B', 2, 'Vocabulary', NULL),
(89, 'A \"connoisseur\" is someone who:', 'Knows little', 'Is an expert judge', 'Hates art', 'Is new to something', 'B', 3, 'Vocabulary', NULL),
(90, '\"Ineffable\" means:', 'Easy to describe', 'Unable to be expressed in words', 'Very small', 'Very large', 'B', 3, 'Vocabulary', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblchucvu`
--

CREATE TABLE `tblchucvu` (
  `MaChucVu` int(11) NOT NULL,
  `TenChucVu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Luong` decimal(19,4) DEFAULT NULL,
  `MaLoaiChucVu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblchucvu`
--

INSERT INTO `tblchucvu` (`MaChucVu`, `TenChucVu`, `Luong`, `MaLoaiChucVu`) VALUES
(1, 'Học Viên', NULL, 1),
(2, 'Giáo Viên Dạy IELTS 5.0-5.5', 15000000.0000, 2),
(3, 'Giáo Viên Dạy IELTS 6.0-6.5', 2000000.0000, 2),
(4, 'Giáo Viên Dạy IELTS 7.0+', 25000000.0000, 2),
(13, 'admin', 10000000.0000, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldiemdanh`
--

CREATE TABLE `tbldiemdanh` (
  `MaDiemDanh` int(11) NOT NULL,
  `MaNguoiDung` int(11) DEFAULT NULL COMMENT 'Giáo viên điểm danh',
  `MaLop` int(11) DEFAULT NULL COMMENT 'Lớp học',
  `NgayHoc` date DEFAULT NULL COMMENT 'Ngày học theo TKB',
  `ThoiGianBatDau` time DEFAULT NULL COMMENT 'Thời gian bắt đầu',
  `ThoiGianKetThuc` time DEFAULT NULL COMMENT 'Thời gian kết thúc',
  `TrangThai` enum('Chưa điểm danh','Có mặt','Đi muộn','Vắng mặt','Hủy lớp') DEFAULT 'Chưa điểm danh',
  `ThoiGianDiemDanh` datetime DEFAULT NULL COMMENT 'Thời gian giáo viên điểm danh',
  `GhiChu` varchar(255) DEFAULT NULL,
  `IsBu` tinyint(1) DEFAULT 0 COMMENT '1: Là buổi dạy bù, 0: Buổi học bình thường'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbldiemdanh`
--

INSERT INTO `tbldiemdanh` (`MaDiemDanh`, `MaNguoiDung`, `MaLop`, `NgayHoc`, `ThoiGianBatDau`, `ThoiGianKetThuc`, `TrangThai`, `ThoiGianDiemDanh`, `GhiChu`, `IsBu`) VALUES
(1, 19, 38, '2025-06-09', '13:00:00', '16:00:00', 'Có mặt', '2025-06-17 11:36:42', 'Điểm danh hộ', 0),
(2, 19, 38, '2025-06-11', '13:00:00', '16:00:00', 'Có mặt', '2025-06-17 11:36:59', 'Điểm danh hộ', 0),
(3, 19, 38, '2025-06-12', '13:00:00', '16:00:00', 'Vắng mặt', '2025-06-17 11:37:18', '', 0),
(4, 19, 38, '2025-06-16', '13:00:00', '16:00:00', 'Có mặt', '2025-06-17 11:37:30', 'Điểm danh hộ', 0),
(5, 19, 38, '2025-06-18', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(6, 19, 38, '2025-06-19', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(7, 19, 38, '2025-06-23', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(8, 19, 38, '2025-06-25', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(9, 19, 38, '2025-06-26', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(10, 19, 38, '2025-06-30', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(11, 19, 38, '2025-07-02', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(12, 19, 38, '2025-07-03', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(13, 19, 38, '2025-07-07', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(14, 19, 38, '2025-07-09', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(15, 19, 38, '2025-07-10', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(16, 19, 38, '2025-07-14', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(17, 19, 38, '2025-07-16', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(18, 19, 38, '2025-07-17', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(19, 19, 38, '2025-07-21', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(20, 19, 38, '2025-07-23', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(21, 19, 38, '2025-07-24', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(22, 19, 38, '2025-07-28', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(23, 19, 38, '2025-07-30', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(24, 19, 38, '2025-07-31', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(25, 19, 38, '2025-08-04', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(26, 19, 38, '2025-08-06', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(27, 19, 38, '2025-08-07', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(28, 19, 38, '2025-08-11', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(29, 19, 38, '2025-08-13', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(30, 19, 38, '2025-08-14', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(31, 19, 38, '2025-08-18', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(32, 19, 38, '2025-08-20', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(33, 19, 38, '2025-08-21', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(34, 19, 38, '2025-08-25', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(35, 19, 38, '2025-08-27', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(36, 19, 38, '2025-08-28', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(37, 19, 39, '2025-06-26', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(38, 19, 39, '2025-06-27', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(39, 19, 39, '2025-06-24', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(40, 19, 39, '2025-07-03', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(41, 19, 39, '2025-07-04', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(42, 19, 39, '2025-07-01', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(43, 19, 39, '2025-07-10', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(44, 19, 39, '2025-07-11', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(45, 19, 39, '2025-07-08', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(46, 19, 39, '2025-07-17', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(47, 19, 39, '2025-07-18', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(48, 19, 39, '2025-07-15', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(49, 19, 39, '2025-07-24', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(50, 19, 39, '2025-07-25', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(51, 19, 39, '2025-07-22', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(52, 19, 39, '2025-07-31', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(53, 19, 39, '2025-08-01', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(54, 19, 39, '2025-07-29', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(55, 19, 39, '2025-08-07', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(56, 19, 39, '2025-08-08', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(57, 19, 39, '2025-08-05', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(58, 19, 39, '2025-08-14', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(59, 19, 39, '2025-08-15', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(60, 19, 39, '2025-08-12', '07:00:00', '10:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(61, 20, 40, '2025-06-25', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(62, 20, 40, '2025-06-27', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(63, 20, 40, '2025-06-28', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(64, 20, 40, '2025-07-02', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(65, 20, 40, '2025-07-04', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(66, 20, 40, '2025-07-05', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(67, 20, 40, '2025-07-09', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(68, 20, 40, '2025-07-11', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(69, 20, 40, '2025-07-12', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(70, 20, 40, '2025-07-16', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(71, 20, 40, '2025-07-18', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(72, 20, 40, '2025-07-19', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(73, 20, 40, '2025-07-23', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(74, 20, 40, '2025-07-25', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(75, 20, 40, '2025-07-26', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(76, 20, 40, '2025-07-30', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(77, 20, 40, '2025-08-01', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(78, 20, 40, '2025-08-02', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(79, 20, 40, '2025-08-06', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(80, 20, 40, '2025-08-08', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(81, 20, 40, '2025-08-09', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(82, 20, 40, '2025-08-13', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(83, 20, 40, '2025-08-15', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(84, 20, 40, '2025-08-16', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(85, 20, 40, '2025-08-20', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(86, 20, 40, '2025-08-22', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(87, 20, 40, '2025-08-23', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(88, 20, 40, '2025-08-27', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(89, 20, 40, '2025-08-29', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(90, 20, 40, '2025-08-30', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(91, 20, 40, '2025-09-03', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(92, 20, 40, '2025-09-05', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(93, 20, 40, '2025-09-06', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(94, 20, 40, '2025-09-10', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(95, 20, 40, '2025-09-12', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(96, 20, 40, '2025-09-13', '13:00:00', '16:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(97, 25, 41, '2025-06-19', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(98, 25, 41, '2025-06-20', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(99, 25, 41, '2025-06-21', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(100, 25, 41, '2025-06-26', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(101, 25, 41, '2025-06-27', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(102, 25, 41, '2025-06-28', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(103, 25, 41, '2025-07-03', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(104, 25, 41, '2025-07-04', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(105, 25, 41, '2025-07-05', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(106, 25, 41, '2025-07-10', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(107, 25, 41, '2025-07-11', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(108, 25, 41, '2025-07-12', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(109, 25, 41, '2025-07-17', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(110, 25, 41, '2025-07-18', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(111, 25, 41, '2025-07-19', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(112, 25, 41, '2025-07-24', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(113, 25, 41, '2025-07-25', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(114, 25, 41, '2025-07-26', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(115, 25, 41, '2025-07-31', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(116, 25, 41, '2025-08-01', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(117, 25, 41, '2025-08-02', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(118, 25, 41, '2025-08-07', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(119, 25, 41, '2025-08-08', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(120, 25, 41, '2025-08-09', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(121, 21, 42, '2025-06-26', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(122, 21, 42, '2025-06-25', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(123, 21, 42, '2025-06-20', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(124, 21, 42, '2025-07-03', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(125, 21, 42, '2025-07-02', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(126, 21, 42, '2025-06-27', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(127, 21, 42, '2025-07-10', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(128, 21, 42, '2025-07-09', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(129, 21, 42, '2025-07-04', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(130, 21, 42, '2025-07-17', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(131, 21, 42, '2025-07-16', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(132, 21, 42, '2025-07-11', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(133, 21, 42, '2025-07-24', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(134, 21, 42, '2025-07-23', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(135, 21, 42, '2025-07-18', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(136, 21, 42, '2025-07-31', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(137, 21, 42, '2025-07-30', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(138, 21, 42, '2025-07-25', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(139, 21, 42, '2025-08-07', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(140, 21, 42, '2025-08-06', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(141, 21, 42, '2025-08-01', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(142, 21, 42, '2025-08-14', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(143, 21, 42, '2025-08-13', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0),
(144, 21, 42, '2025-08-08', '18:00:00', '21:00:00', 'Chưa điểm danh', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldoanthi`
--

CREATE TABLE `tbldoanthi` (
  `MaDoan` int(11) NOT NULL,
  `TieuDe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NoiDung` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LoaiDoan` enum('Reading','Listening') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DoKho` tinyint(4) DEFAULT 1 COMMENT '1: Dễ, 2: Trung bình, 3: Khó',
  `AudioFile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Chỉ dùng cho Listening',
  `ThoiLuong` int(11) DEFAULT NULL COMMENT 'Thời lượng audio (giây), chỉ dùng cho Listening'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbldoanthi`
--

INSERT INTO `tbldoanthi` (`MaDoan`, `TieuDe`, `NoiDung`, `LoaiDoan`, `DoKho`, `AudioFile`, `ThoiLuong`) VALUES
(1, 'The History of Coffee', 'Coffee was first discovered in Ethiopia, where it grew wild. According to legend, a goat herder named Kaldi noticed his goats became very energetic after eating berries from a certain tree. He tried the berries himself and experienced the same effect. By the 15th century, coffee was being grown in the Arabian Peninsula and by the 17th century, it had spread to Europe. Today, coffee is one of the most popular beverages worldwide.', 'Reading', 2, NULL, NULL),
(2, 'University Library Announcement', 'Transcript: The university library will be closed this weekend for renovations. All due dates for books have been extended to next Monday. Students can still access online resources through the library website. For urgent inquiries, please email library@university.edu.', 'Listening', 1, 'library_announcement.mp3', 45),
(3, 'The Benefits of Exercise', 'Regular physical activity is one of the most important things you can do for your health. Exercise helps control weight, reduce the risk of cardiovascular disease, and strengthen bones and muscles. It can also improve mental health by reducing symptoms of depression and anxiety. Adults should get at least 150 minutes of moderate-intensity exercise per week. Simple activities like brisk walking, swimming, or cycling can provide significant health benefits. Making exercise a regular habit is key to long-term wellbeing.', 'Reading', 2, NULL, NULL),
(4, 'Train Station Announcement', 'Transcript: Attention passengers. The 14:15 train to Manchester is delayed by approximately 20 minutes due to signaling problems. We apologize for the inconvenience. Passengers for Liverpool can use platform 3 where their train is ready for boarding. The café on platform 1 is offering complimentary drinks to affected passengers. For further information, please check the information screens or speak to station staff.', 'Listening', 2, 'train_announcement.mp3', 60);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblformnhaphoc`
--

CREATE TABLE `tblformnhaphoc` (
  `MaForm` int(11) NOT NULL,
  `HoTen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `gioitinh` varchar(255) DEFAULT NULL,
  `Sdt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DiaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NgayGui` datetime DEFAULT NULL,
  `trangthai` varchar(255) DEFAULT NULL,
  `TenKhoaHoc` varchar(255) DEFAULT NULL,
  `DiemThiThu` float DEFAULT NULL,
  `NgayThiThu` datetime DEFAULT NULL,
  `TrinhDoDuDoan` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblformnhaphoc`
--

INSERT INTO `tblformnhaphoc` (`MaForm`, `HoTen`, `NgaySinh`, `gioitinh`, `Sdt`, `DiaChi`, `Email`, `NgayGui`, `trangthai`, `TenKhoaHoc`, `DiemThiThu`, `NgayThiThu`, `TrinhDoDuDoan`) VALUES
(1, 'Lê Văn Cừ', '2000-03-10 00:00:00', 'Nam', '0123987654', '05 Lê Văn Lương', 'levancu@gmail.com', '2023-08-01 00:00:00', 'Hoàn thành', 'IELTS mất gốc', NULL, NULL, NULL),
(2, 'Phạm Thị Ngân', '2001-04-25 00:00:00', 'Nữ', '0123765498', '101 Huỳnh Thúc Kháng', 'phamthingan@gmail.com', '2023-07-14 00:00:00', 'Hoàn thành', 'IELTS mất gốc', NULL, NULL, NULL),
(3, 'Hoàng Văn Hùng', '2003-05-30 00:00:00', 'Nam', '0192837465', '23 Nguyễn Trãi', 'hoangvanhung@gmail.com', '2023-08-13 00:00:00', 'Hoàn thành', 'IELTS mất gốc', NULL, NULL, NULL),
(4, 'Mai Văn Hải', '2005-05-14 00:00:00', 'Nam', '0365846539', '24 Mai Hắc Đế', 'maivanhai@gmail.com', '2023-07-03 00:00:00', 'Hoàn thành', 'IELTS mất gốc', NULL, NULL, NULL),
(5, 'Hoàng Nhật Mai', '2004-06-23 00:00:00', 'Nữ', '0453768463', '45 Nguyễn Trãi', 'hoangnhatmai@gmail.com.com', '2024-06-29 00:00:00', 'Hoàn thành', NULL, NULL, NULL, NULL),
(6, 'Nguyễn Văn Nghĩa', '2003-02-18 00:00:00', 'Nam', '0846583927', '23 Trần Nhân Tông', 'nguyenvannghia@gmail.com', '2024-06-15 00:00:00', 'Hoàn thành', NULL, NULL, NULL, NULL),
(7, 'Đỗ Anh Thư', '2002-08-24 00:00:00', 'Nữ', '064537562', '41 Hoàng Hoa Thám', 'doanhthu@gmail.com', '2024-07-01 00:00:00', 'Hoàn thành', NULL, NULL, NULL, NULL),
(8, 'Vũ Ngọc Trâm', '2003-07-28 00:00:00', 'Nữ', '0365745697', '11 Trần Hưng Đạo', 'vungoctram@gmail.com', '2024-07-03 00:00:00', 'Hoàn thành', NULL, NULL, NULL, NULL),
(9, 'Vũ Mạnh Hùng', '2003-05-28 00:00:00', 'Nam', '064537597', '135 Nguyễn Chí Thanh', 'vumanhhung@gmail.com', '2024-07-20 00:00:00', 'Hoàn thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(10, 'Trần Bảo Vệ', '2002-06-28 00:00:00', 'Nam', '0165738463', '59 Nguyễn Chí Thanh', 'tranbaove@gmail.com', '2024-08-16 00:00:00', 'Hoàn Thành', 'IELTS mất gốc', NULL, NULL, NULL),
(12, 'chảo cáo nhàn', '2003-11-29 19:35:42', 'Nam', '0867898896', 'lao cai', 'nhan@gmail.com', '2024-11-29 19:35:42', 'Hoàn Thành', 'Ielt mg', NULL, NULL, NULL),
(13, 'Dương', '2002-02-05 00:00:00', 'Nam', '0453756496', 'Trà Đoài, Quang Trung, Thái ', 'duong@gmail.com', '2025-06-17 10:57:06', 'Hoàn Thành', 'Khóa IELTS mất gốc', 4, '2025-06-17 11:15:23', 'Beginner'),
(14, 'Trần Minh Thư', '2004-07-07 00:00:00', 'Nữ', '0453756457', 'Hồ Tây', 'tranminhthu@gmail.com', '2025-06-17 10:59:20', 'Hoàn Thành', 'Khóa IELTS cấp tốc', 3, '2025-06-17 11:10:31', 'Beginner'),
(15, 'Nguyễn Thị Tâm', '2002-03-05 17:00:00', 'Nữ', '0325684539', 'Hà Nội', 'nguyenthitam@gmail.com', '2025-06-17 11:01:40', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(16, 'Vũ Minh Thiện', '2001-03-07 00:00:00', 'Nam', '0275648564', 'Đại Từ', 'vuminhthien@gmail.com', '2025-06-17 11:10:43', 'Chờ Xét Duyệt', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(17, 'Nguyễn Đăng Đan', '2000-06-01 00:00:00', 'Nam', '0453756384', 'Chùa Láng', 'nguyendangdan@gmail.com', '2025-06-17 11:12:07', 'Hoàn Thành', 'Khóa IELTS 5.0-5.5', 5, '2025-06-17 11:43:03', '5.0-5.5'),
(18, 'Trần Phàm', '2004-03-08 17:00:00', 'Nam', '0265846593', 'Số 12, Nguyễn Trãi', 'tranpham@gmail.com', '2025-06-17 11:17:24', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(19, 'Mai Lung Linh', '2002-03-06 17:00:00', 'Nữ', '0945365745', 'Hồ Gươm', 'mailunglinh@gmail.com', '2025-06-17 11:18:15', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(20, 'Nguyễn Văn Long', '2001-11-13 17:00:00', 'Nam', '0275648694', 'Số 24, Trần Nhân Tông', 'nguyenvanlong@gmail.com', '2025-06-17 11:19:28', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(21, 'Vũ Quang Vinh', '2005-10-11 17:00:00', 'Nam', '0264836594', 'Số 56, Trần Nhân Tông', 'vuquangminh@gmail.com', '2025-06-17 11:20:35', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(22, 'Nguyễn Mai Linh', '2001-03-12 17:00:00', 'Nữ', '0365849573', '46 Nguyễn Chí Thanh', 'nguyenmailinh@gmail.com', '2025-06-17 11:22:04', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(23, 'Phạm Văn Quang', '2004-06-08 17:00:00', 'Nam', '0364756385', '45 Hồ Tây', 'phamvanquang@gmail.com', '2025-06-17 11:22:59', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(24, 'Vũ Như Yên', '2003-09-09 17:00:00', 'Nữ', '0362758435', '35 Nguyễn Chí Thanh', 'vunhuyen@gmail.com', '2025-06-17 11:24:30', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(25, 'Nguyễn Anh Thư', '2004-08-03 17:00:00', 'Nữ', '0564836593', '46 Chùa Láng', 'doanhthu@gmail.com', '2025-06-17 11:33:58', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(26, 'Vũ Văn Thái', '2006-08-07 17:00:00', 'Nam', '0453859365', '34 Cầu Giấy', 'vuvanthai@gmail.com', '2025-06-17 11:35:29', 'Hoàn Thành', 'Khóa IELTS mất gốc', NULL, NULL, NULL),
(27, 'Trần Văn Hoàng', '2005-03-07 17:00:00', 'Nam', '0234567934', '34 Hồ Tây', 'tranvanhoang@gmail.com', '2025-06-17 11:54:06', 'Hoàn Thành', 'Khóa IELTS 5.0-5.5', NULL, NULL, NULL),
(28, 'Vũ Văn Nghĩa', '2004-03-08 17:00:00', 'Nam', '0374628576', '56 Mai Hắc Đế', 'vuvannghia@gmail.com', '2025-06-17 11:55:36', 'Hoàn Thành', 'Khóa IELTS 7.0+', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblketquathithu`
--

CREATE TABLE `tblketquathithu` (
  `MaKetQua` int(11) NOT NULL,
  `MaForm` int(11) DEFAULT NULL,
  `MaCauHoi` int(11) DEFAULT NULL,
  `DapAnChon` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Diem` tinyint(4) DEFAULT 0 COMMENT '0: Sai, 1: Đúng'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblketquathithu`
--

INSERT INTO `tblketquathithu` (`MaKetQua`, `MaForm`, `MaCauHoi`, `DapAnChon`, `Diem`) VALUES
(1, 14, 43, 'B', 1),
(2, 14, 48, 'B', 1),
(3, 14, 42, 'B', 1),
(4, 14, 45, 'B', 1),
(5, 14, 41, 'B', 1),
(6, 14, 49, 'B', 1),
(7, 14, 46, 'B', 1),
(8, 14, 44, 'B', 0),
(9, 14, 47, 'B', 1),
(10, 14, 50, 'B', 1),
(11, 14, 38, 'B', 0),
(12, 14, 35, 'B', 0),
(13, 14, 32, 'B', 1),
(14, 14, 39, 'B', 0),
(15, 14, 36, 'B', 1),
(16, 14, 34, 'B', 0),
(17, 14, 31, 'B', 1),
(18, 14, 40, 'B', 0),
(19, 14, 37, 'B', 1),
(20, 14, 33, 'B', 1),
(21, 14, 88, 'B', 1),
(22, 14, 3, 'B', 1),
(23, 14, 59, 'B', 1),
(24, 14, 67, 'B', 1),
(25, 14, 57, 'B', 0),
(26, 14, 4, 'B', 1),
(27, 14, 10, 'B', 1),
(28, 14, 52, 'B', 1),
(29, 14, 77, 'B', 0),
(30, 14, 8, 'B', 0),
(31, 14, 73, 'B', 0),
(32, 14, 6, 'B', 0),
(33, 14, 89, 'B', 1),
(34, 14, 78, 'B', 0),
(35, 13, 30, 'B', 1),
(36, 13, 26, 'B', 0),
(37, 13, 25, 'B', 1),
(38, 13, 29, 'B', 0),
(39, 13, 15, 'B', 1),
(40, 13, 16, 'B', 0),
(41, 13, 23, 'B', 0),
(42, 13, 27, 'B', 0),
(43, 13, 24, 'B', 0),
(44, 13, 28, 'B', 1),
(45, 13, 39, 'B', 0),
(46, 13, 40, 'B', 0),
(47, 13, 32, 'B', 1),
(48, 13, 33, 'B', 1),
(49, 13, 36, 'B', 1),
(50, 13, 35, 'B', 0),
(51, 13, 31, 'B', 1),
(52, 13, 38, 'B', 0),
(53, 13, 34, 'B', 0),
(54, 13, 37, 'B', 1),
(55, 13, 87, 'B', 1),
(56, 13, 3, 'B', 1),
(57, 13, 68, 'B', 0),
(58, 13, 77, 'B', 0),
(59, 13, 66, 'B', 0),
(60, 13, 86, 'B', 1),
(61, 13, 51, 'B', 1),
(62, 13, 84, 'B', 1),
(63, 13, 75, 'B', 0),
(64, 13, 72, 'B', 0),
(65, 13, 2, 'B', 0),
(66, 13, 61, 'B', 1),
(67, 13, 56, 'B', 0),
(68, 13, 69, 'B', 0),
(69, 13, 10, 'B', 1),
(70, 13, 62, 'B', 0),
(71, 13, 6, 'B', 0),
(72, 13, 76, 'B', 1),
(73, 13, 4, 'B', 1),
(74, 13, 80, 'B', 1),
(75, 13, 71, 'B', 0),
(76, 13, 7, 'B', 0),
(77, 13, 89, 'B', 1),
(78, 13, 1, 'B', 0),
(79, 13, 59, 'B', 1),
(80, 13, 60, 'B', 1),
(81, 13, 65, 'B', 0),
(82, 13, 53, 'B', 0),
(83, 13, 67, 'B', 1),
(84, 13, 74, 'B', 0),
(85, 13, 83, 'B', 1),
(86, 13, 70, 'B', 1),
(87, 13, 85, 'B', 1),
(88, 13, 57, 'C', 0),
(89, 13, 55, 'B', 1),
(90, 13, 5, 'C', 1),
(91, 13, 58, 'B', 1),
(92, 13, 73, 'B', 0),
(93, 13, 90, 'C', 0),
(94, 13, 78, 'C', 0),
(95, 17, 26, 'C', 1),
(96, 17, 25, 'B', 1),
(97, 17, 24, 'C', 1),
(98, 17, 27, 'C', 1),
(99, 17, 23, 'C', 1),
(100, 17, 29, 'A', 1),
(101, 17, 30, 'B', 1),
(102, 17, 15, 'B', 1),
(103, 17, 16, 'C', 1),
(104, 17, 28, 'B', 1),
(105, 17, 40, 'C', 1),
(106, 17, 33, 'B', 1),
(107, 17, 37, 'B', 1),
(108, 17, 38, 'C', 1),
(109, 17, 32, 'B', 1),
(110, 17, 39, 'C', 1),
(111, 17, 31, 'B', 1),
(112, 17, 36, 'B', 1),
(113, 17, 34, 'C', 1),
(114, 17, 35, 'C', 1),
(115, 17, 10, 'B', 1),
(116, 17, 68, 'C', 1),
(117, 17, 6, 'C', 1),
(118, 17, 83, 'B', 1),
(119, 17, 90, 'B', 1),
(120, 17, 86, 'B', 1),
(121, 17, 55, 'B', 1),
(122, 17, 53, 'C', 1),
(123, 17, 59, 'B', 1),
(124, 17, 77, 'A', 1),
(125, 17, 58, 'B', 1),
(126, 17, 85, 'B', 1),
(127, 17, 69, 'A', 1),
(128, 17, 7, 'A', 1),
(129, 17, 56, 'C', 1),
(130, 17, 72, 'A', 1),
(131, 17, 66, 'D', 0),
(132, 17, 89, 'D', 0),
(133, 17, 81, 'D', 0),
(134, 17, 64, 'D', 0),
(135, 17, 52, 'D', 0),
(136, 17, 62, 'D', 0),
(137, 17, 51, 'D', 0),
(138, 17, 88, 'D', 0),
(139, 17, 1, 'D', 0),
(140, 17, 8, 'D', 0),
(141, 17, 82, 'D', 0),
(142, 17, 61, 'D', 0),
(143, 17, 70, 'D', 0),
(144, 17, 5, 'D', 0),
(145, 17, 4, 'D', 0),
(146, 17, 76, 'D', 0),
(147, 17, 84, 'D', 0),
(148, 17, 60, 'D', 0),
(149, 17, 80, 'D', 0),
(150, 17, 79, 'D', 0),
(151, 17, 74, 'D', 0),
(152, 17, 57, 'D', 0),
(153, 17, 2, 'D', 0),
(154, 17, 87, 'D', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblkhoahoc`
--

CREATE TABLE `tblkhoahoc` (
  `MaKhoaHoc` int(11) NOT NULL,
  `TenKhoaHoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `hocphi` float DEFAULT NULL,
  `UuDai` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `thoigianuudai` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblkhoahoc`
--

INSERT INTO `tblkhoahoc` (`MaKhoaHoc`, `TenKhoaHoc`, `hocphi`, `UuDai`, `thoigianuudai`) VALUES
(1, 'Khóa IELTS mất gốc', 2000000, '50', '2024-11-20'),
(2, 'Khóa IELTS cấp tốc', 2500000, '20', '2024-11-20'),
(3, 'Khóa IELTS 1 kèm 1', 3000000, '30', '2024-11-20'),
(4, 'Khóa IELTS 5.0-5.5', 3500000, '15', NULL),
(5, 'Khóa IELTS 6.0-6.5', 4000000, '50', NULL),
(6, 'Khóa IELTS 7.0+', 4500000, '22', '2024-12-12'),
(7, 'test put ok', 99999, '30', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblloaichucvu`
--

CREATE TABLE `tblloaichucvu` (
  `MaLoaiChucVu` int(11) NOT NULL,
  `TenLoaiChucVu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblloaichucvu`
--

INSERT INTO `tblloaichucvu` (`MaLoaiChucVu`, `TenLoaiChucVu`) VALUES
(1, 'Học Viên'),
(2, 'Giáo Viên'),
(7, 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbllophoc`
--

CREATE TABLE `tbllophoc` (
  `MaLop` int(11) NOT NULL,
  `TenLopHoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NgayKhaiGiang` datetime DEFAULT NULL,
  `ThoiGianHoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ThuHoc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaKhoaHoc` int(11) DEFAULT NULL,
  `CaHoc` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbllophoc`
--

INSERT INTO `tbllophoc` (`MaLop`, `TenLopHoc`, `NgayKhaiGiang`, `ThoiGianHoc`, `ThuHoc`, `MaKhoaHoc`, `CaHoc`) VALUES
(1, 'I-MG-01', '2023-09-01 00:00:00', '36 buổi', '2,4,6', 1, 'Sáng'),
(2, 'I-MG-02', '2024-09-01 00:00:00', '36 buổi', '3,5,7', 1, 'Chiều'),
(35, 'I-7-01', '2024-10-20 00:00:00', '36 buổi', '2,4,6', 6, 'Sáng'),
(38, 'I-MG-03', '2025-06-09 00:00:00', '36 buổi', '2,4,5', 1, 'Chiều'),
(39, 'I-MG-04', '2025-06-24 00:00:00', '24 buổi', '5,6,3', 1, 'Sáng'),
(40, 'I-5-01', '2025-06-25 00:00:00', '36 buổi', '4,6,7', 4, 'Chiều'),
(41, 'I-7-02', '2025-06-19 00:00:00', '24 buổi', '5,6,7', 6, 'Tối'),
(42, 'I-CT-01', '2025-06-20 00:00:00', '24 buổi', '5,4,6', 2, 'Tối');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnguoidung`
--

CREATE TABLE `tblnguoidung` (
  `MaNguoiDung` int(11) NOT NULL,
  `HoTen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `gioitinh` varchar(255) DEFAULT NULL,
  `Sdt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DiaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TenDangNhap` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MatKhau` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `machucvu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblnguoidung`
--

INSERT INTO `tblnguoidung` (`MaNguoiDung`, `HoTen`, `NgaySinh`, `gioitinh`, `Sdt`, `DiaChi`, `Email`, `TenDangNhap`, `MatKhau`, `machucvu`) VALUES
(1, 'Nguyễn Văn An', '1984-01-15 00:00:00', 'Nam', '0123456789', '12 Lê Duẩn', 'nguyenvanan@gmail.com', 'nguyenvanan', '12345', 3),
(2, 'Trần Thị Linh Chi', '1986-02-20 00:00:00', 'Nữ', '0987654321', '38 Phố Huế', 'tranthib@gmail.com', 'tranthilinhchi', '23456', 3),
(4, 'Phạm Thị Ngân', '2001-04-25 00:00:00', 'Nữ', '0123765498', '101 Huỳnh Thúc Kháng', 'phamthingan@gmail.com', 'phamthingan', '34567', 1),
(5, 'Hoàng Văn Hùng', '2003-05-30 00:00:00', 'Nam', '0192837465', '23 Nguyễn Trãi', 'hoangvanhung@gmail.com', 'hoangvanhung', '45678', 1),
(6, 'Mai Văn Hải', '2005-05-14 00:00:00', 'Nam', '0365846539', '24 Mai Hắc Đế', 'maivanhai@gmail.com', 'maivanhai', '56789', 1),
(7, 'Hoàng Nhật Mai', '2004-06-23 00:00:00', 'Nữ', '0453768463', '45 Nguyễn Trãi', 'hoangnhatmai@gmail.com.com', 'hoangnhatmai', '98765', 1),
(8, 'Nguyễn Văn Nghĩa', '2003-02-18 00:00:00', 'Nam', '0846583927', '23 Trần Nhân Tông', 'nguyenvannghia@gmail.com', 'nguyenvannghia', '87654', 1),
(9, 'Đỗ Anh Thư', '2002-08-24 00:00:00', 'Nữ', '064537562', '41 Hoàng Hoa Thám', 'doanhthu@gmail.com', 'đoanhthu', '76543', 1),
(10, 'Vũ Ngọc Trâm', '2003-07-28 00:00:00', 'Nữ', '0365745697', '11 Trần Hưng Đạo', 'vungoctram@gmail.com', 'vungoctram', '65432', 1),
(15, 'Vũ Mạnh Hùng', '2003-05-28 00:00:00', 'Nam', '064537597', '135 Nguyễn Chí Thanh', 'vumanhhung@gmail.com', 'vumanhhung', '12345', 1),
(18, 'Trần Văn Hoàng', '1985-01-10 00:00:00', 'Nam', '0901234567', '123 Trần Hưng Đạo', 'tranvanhoang@gmail.com', 'tranvanhoang', '12345', 2),
(19, 'Nguyễn Thị Mai', '1990-03-15 00:00:00', 'Nữ', '0907654321', '456 Phạm Ngọc Thạch', 'nguyenthiemai@gmail.com', 'nguyenthimai', '12345', 2),
(20, 'Phạm Minh Tuấn', '1988-02-20 00:00:00', 'Nam', '0912345678', '789 Nguyễn Trãi', 'phaminhtu@gmail.com', 'phamminhtuan', '12345', 2),
(21, 'Lê Thị Hồng', '1987-04-30 00:00:00', 'Nữ', '0918765432', '101 Đinh Tiên Hoàng', 'lethihong@gmail.com', 'lethihong', '12345', 3),
(22, 'Nguyễn Văn Bảo', '1986-05-25 00:00:00', 'Nam', '0901122334', '202 Lê Lợi', 'nguyenvanbao@gmail.com', 'nguyenvanbao', '12345', 3),
(23, 'Hoàng Thị Hoa', '1989-07-14 00:00:00', 'Nữ', '0902233445', '303 Bạch Đằng', 'hoangthihoa@gmail.com', 'hoangthihoa', '12345', 3),
(24, 'Nguyễn Văn Duy', '1984-06-10 00:00:00', 'Nam', '0903344556', '404 Trần Quốc Toản', 'nguyenvandu@gmail.com', 'nguyenvanduy', '12345', 4),
(25, 'Trần Thị Kim', '1992-08-22 00:00:00', 'Nữ', '0904455667', '505 Nguyễn Văn Cừ', 'tranthikim@gmail.com', 'tranthikim', '12345', 4),
(26, 'Phạm Văn Khải', '1983-09-12 00:00:00', 'Nam', '0905566778', '606 Lê Duẩn', 'phamvankhai@gmail.com', 'phamvankhai', '12345', 4),
(39, 'Chảo Cáo Nhàn', '2024-11-23 13:40:03', 'Nam', '0867898896', 'laocai', 'cnhan123@gmail.com', 'chaocaonhan', '12345', 1),
(48, 'admin', NULL, NULL, NULL, NULL, NULL, 'admin', '123', 13),
(49, 'Nguyễn Thị Tâm', '2002-03-05 17:00:00', 'Nữ', '0325684539', 'Hà Nội', 'nguyenthitam@gmail.com', 'nguyenthitam', '12345', 1),
(50, 'Trần Phàm', '2004-03-08 17:00:00', 'Nam', '0265846593', 'Số 12, Nguyễn Trãi', 'tranpham@gmail.com', 'tranpham', '12345', 1),
(51, 'Mai Lung Linh', '2002-03-06 17:00:00', 'Nữ', '0945365745', 'Hồ Gươm', 'mailunglinh@gmail.com', 'mailunglinh', '12345', 1),
(52, 'Nguyễn Văn Long', '2001-11-13 17:00:00', 'Nam', '0275648694', 'Số 24, Trần Nhân Tông', 'nguyenvanlong@gmail.com', 'nguyenvanlong', '12345', 1),
(53, 'Vũ Quang Vinh', '2005-10-11 17:00:00', 'Nam', '0264836594', 'Số 56, Trần Nhân Tông', 'vuquangminh@gmail.com', 'vuquangvinh', '12345', 1),
(54, 'Nguyễn Mai Linh', '2001-03-12 17:00:00', 'Nữ', '0365849573', '46 Nguyễn Chí Thanh', 'nguyenmailinh@gmail.com', 'nguyenmailinh', '12345', 1),
(55, 'Phạm Văn Quang', '2004-06-08 17:00:00', 'Nam', '0364756385', '45 Hồ Tây', 'phamvanquang@gmail.com', 'phamvanquang', '12345', 1),
(56, 'Vũ Như Yên', '2003-09-09 17:00:00', 'Nữ', '0362758435', '35 Nguyễn Chí Thanh', 'vunhuyen@gmail.com', 'vunhuyen', '12345', 1),
(57, 'Nguyễn Anh Thư', '2004-08-03 17:00:00', 'Nữ', '0564836593', '46 Chùa Láng', 'doanhthu@gmail.com', 'nguyenanhthu', '12345', 1),
(58, 'Vũ Văn Thái', '2006-08-07 17:00:00', 'Nam', '0453859365', '34 Cầu Giấy', 'vuvanthai@gmail.com', 'vuvanthai', '12345', 1),
(59, 'Trần Văn Hoàng', '2005-03-07 17:00:00', 'Nam', '0234567934', '34 Hồ Tây', 'tranvanhoang@gmail.com', 'tranvanhoang', '12345', 1),
(60, 'Vũ Văn Nghĩa', '2004-03-08 17:00:00', 'Nam', '0374628576', '56 Mai Hắc Đế', 'vuvannghia@gmail.com', 'vuvannghia', '12345', 1),
(61, 'Trần Minh Thư', '2004-07-07 00:00:00', 'Nữ', '0453756457', 'Hồ Tây', 'tranminhthu@gmail.com', 'tranminhthu', '12345', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnguoi_lophoc`
--

CREATE TABLE `tblnguoi_lophoc` (
  `MaNguoiDung` int(11) NOT NULL,
  `MaLop` int(11) NOT NULL,
  `TrangThai` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diemkiemtra` float DEFAULT NULL,
  `diemcuoiki` float DEFAULT NULL,
  `uudai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblnguoi_lophoc`
--

INSERT INTO `tblnguoi_lophoc` (`MaNguoiDung`, `MaLop`, `TrangThai`, `diemkiemtra`, `diemcuoiki`, `uudai`) VALUES
(1, 1, 'Hoàn thành', 9, 9, 0),
(2, 2, 'Đang học', NULL, NULL, 0),
(5, 1, 'Đạt', 6, 5, 0),
(6, 1, 'Đạt', 5, 5.5, 0),
(7, 2, 'Đạt', 5, 6.5, 0),
(8, 2, 'Đạt', 4, 5, 0),
(9, 2, 'Đạt', 5, 6.5, 0),
(10, 2, 'Đạt', 5, 6, 0),
(19, 38, 'Đang Học', NULL, NULL, NULL),
(19, 39, 'Đang Học', NULL, NULL, NULL),
(20, 40, 'Đang Học', NULL, NULL, NULL),
(21, 42, 'Đang Học', NULL, NULL, NULL),
(25, 35, 'Hoàn Thành', NULL, NULL, 0),
(25, 41, 'Đang Học', NULL, NULL, NULL),
(39, 35, 'Đạt', 8.5, 8, 0),
(49, 38, 'Đang Học', NULL, NULL, 0),
(50, 38, 'Đang Học', NULL, NULL, 0),
(51, 38, 'Đang Học', NULL, NULL, 0),
(52, 38, 'Đang Học', NULL, NULL, 0),
(53, 38, 'Đang Học', NULL, NULL, 0),
(54, 38, 'Đang Học', NULL, NULL, 0),
(55, 38, 'Đang Học', NULL, NULL, 0),
(56, 38, 'Đang Học', NULL, NULL, 0),
(57, 38, 'Đang Học', NULL, NULL, 0),
(58, 38, 'Đang Học', NULL, NULL, 0),
(59, 40, 'Đang Học', NULL, NULL, 0),
(60, 41, 'Đang Học', NULL, NULL, 0),
(61, 42, 'Đang Học', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblphonghoc`
--

CREATE TABLE `tblphonghoc` (
  `MaPhong` int(11) NOT NULL,
  `TenPhong` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblphonghoc`
--

INSERT INTO `tblphonghoc` (`MaPhong`, `TenPhong`) VALUES
(1, '101'),
(2, '102'),
(3, '201');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbltkb`
--

CREATE TABLE `tbltkb` (
  `matkb` bigint(20) NOT NULL,
  `ThuHoc` int(11) DEFAULT NULL,
  `TGBatDau` time DEFAULT NULL,
  `TGKetThuc` time DEFAULT NULL,
  `MaPhong` int(11) DEFAULT NULL,
  `MaLop` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbltkb`
--

INSERT INTO `tbltkb` (`matkb`, `ThuHoc`, `TGBatDau`, `TGKetThuc`, `MaPhong`, `MaLop`) VALUES
(1, 2, '07:00:00', '10:00:00', 1, NULL),
(2, 2, '13:00:00', '16:00:00', 1, NULL),
(3, 2, '18:00:00', '21:00:00', 1, NULL),
(4, 3, '07:00:00', '10:00:00', 1, 39),
(5, 3, '13:00:00', '16:00:00', 1, NULL),
(6, 3, '18:00:00', '21:00:00', 1, NULL),
(7, 4, '07:00:00', '10:00:00', 1, NULL),
(8, 4, '13:00:00', '16:00:00', 1, 40),
(9, 4, '18:00:00', '21:00:00', 1, NULL),
(10, 5, '07:00:00', '10:00:00', 1, 39),
(11, 5, '13:00:00', '16:00:00', 1, NULL),
(12, 5, '18:00:00', '21:00:00', 1, 41),
(13, 6, '07:00:00', '10:00:00', 1, 39),
(14, 6, '13:00:00', '16:00:00', 1, 40),
(15, 6, '18:00:00', '21:00:00', 1, 41),
(16, 7, '07:00:00', '10:00:00', 1, NULL),
(17, 7, '13:00:00', '16:00:00', 1, 40),
(18, 7, '18:00:00', '21:00:00', 1, 41),
(19, 2, '07:00:00', '10:00:00', 2, NULL),
(20, 2, '13:00:00', '16:00:00', 2, 38),
(21, 2, '18:00:00', '21:00:00', 2, NULL),
(22, 3, '07:00:00', '10:00:00', 2, NULL),
(23, 3, '13:00:00', '16:00:00', 2, NULL),
(24, 3, '18:00:00', '21:00:00', 2, NULL),
(25, 4, '07:00:00', '10:00:00', 2, NULL),
(26, 4, '13:00:00', '16:00:00', 2, 38),
(27, 4, '18:00:00', '21:00:00', 2, 42),
(28, 5, '07:00:00', '10:00:00', 2, NULL),
(29, 5, '13:00:00', '16:00:00', 2, 38),
(30, 5, '18:00:00', '21:00:00', 2, 42),
(31, 6, '07:00:00', '10:00:00', 2, NULL),
(32, 6, '13:00:00', '16:00:00', 2, NULL),
(33, 6, '18:00:00', '21:00:00', 2, 42),
(34, 7, '07:00:00', '10:00:00', 2, NULL),
(35, 7, '13:00:00', '16:00:00', 2, NULL),
(36, 7, '18:00:00', '21:00:00', 2, NULL),
(37, 2, '07:00:00', '10:00:00', 3, NULL),
(38, 2, '13:00:00', '16:00:00', 3, NULL),
(39, 2, '18:00:00', '21:00:00', 3, NULL),
(40, 3, '07:00:00', '10:00:00', 3, NULL),
(41, 3, '13:00:00', '16:00:00', 3, NULL),
(42, 3, '18:00:00', '21:00:00', 3, NULL),
(43, 4, '07:00:00', '10:00:00', 3, NULL),
(44, 4, '13:00:00', '16:00:00', 3, NULL),
(45, 4, '18:00:00', '21:00:00', 3, NULL),
(46, 5, '07:00:00', '10:00:00', 3, NULL),
(47, 5, '13:00:00', '16:00:00', 3, NULL),
(48, 5, '18:00:00', '21:00:00', 3, NULL),
(49, 6, '07:00:00', '10:00:00', 3, NULL),
(50, 6, '13:00:00', '16:00:00', 3, NULL),
(51, 6, '18:00:00', '21:00:00', 3, NULL),
(52, 7, '07:00:00', '10:00:00', 3, NULL),
(53, 7, '13:00:00', '16:00:00', 3, NULL),
(54, 7, '18:00:00', '21:00:00', 3, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbltuvan`
--

CREATE TABLE `tbltuvan` (
  `matuvan` bigint(20) NOT NULL,
  `HoTen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaygui` date DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `NgheNghiep` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CoSoGanNhat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CauHoiTuVan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TrangThai` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbltuvan`
--

INSERT INTO `tbltuvan` (`matuvan`, `HoTen`, `ngaygui`, `sdt`, `NgheNghiep`, `CoSoGanNhat`, `CauHoiTuVan`, `TrangThai`) VALUES
(1, 'Nguyễn Ngọc Anh', '2025-06-15', '0123456789', 'Phụ huynh', 'HN: 107 Xuân La - Số nhà D21, Bắc Từ Liêm', 'Trung tâm có những khóa học nào phù hợp với trình độ cấp 3 của con tôi ?', 'Hoàn thành'),
(2, 'Trần Bảo Ngọc', '2025-06-14', '0987654321', 'Học sinh cấp 2', 'HN: 22 Nguyễn Hoàng, Mỹ Đình, Nam Từ Liêm', 'Phải học mất bao lâu để em có thể đạt được 7.5 IELTS ?', 'Hoàn thành'),
(3, 'Lê Văn Liêm', '2024-03-10', '0123987654', 'Học sinh cấp 3', 'HN: 44 Trần Quốc Hoàn, Cầu Giấy', 'Chương trình học có theo chuẩn quốc tế không? Trung tâm có sử dụng giáo trình nào?', 'Hoàn thành'),
(4, 'Phạm Thị Hà', '2024-04-25', '0123765498', 'Người đi làm', 'HN: 214 Trường Chinh, Đống Đa', 'Khóa học có linh hoạt về thời gian không? Có lớp học buổi tối hoặc cuối tuần không?', 'Hoàn thành'),
(5, 'Hoàng Văn Hùng', '2024-05-30', '0192837465', 'Sinh viên năm 1,2', 'HN: 230 Lò Đúc, Hai Bà Trưng', 'Phương pháp giảng dạy của trung tâm là gì? Trung tâm có áp dụng phương pháp học tập tương tác không?', 'Hoàn thành'),
(6, 'Mai Hắc Đế', '2024-05-14', '0365846539', 'Sinh viên năm 3,4', 'HN: 205 Minh Khai, Hai Bà Trưng', 'Giáo viên tại trung tâm có phải là người bản xứ không? Họ có bằng cấp và kinh nghiệm giảng dạy như thế nào?', 'Hoàn thành'),
(7, 'Hoàng Thùy Chi', '2024-06-23', '0453768463', 'Phụ huynh', 'HN: 468 Nguyễn Văn Cừ, Long Biên', 'Trung tâm có tổ chức các hoạt động ngoại khóa hay câu lạc bộ tiếng Anh để thực hành thêm không?', 'Hoàn thành'),
(8, 'Nguyễn Trọng Nghĩa', '2024-08-18', '0846583927', 'Người đi làm', 'HN: 97 Cao Lỗ, Uy Nỗ, Đông Anh', 'Học phí của các khóa học là bao nhiêu? Có chính sách ưu đãi hoặc trả góp không?', 'Hoàn thành'),
(9, 'Đỗ Mai Anh', '2025-06-16', '064537562', 'Sinh viên', 'HN: 737 Quang Trung, Hà Đông', 'Trung tâm có cách nào để theo dõi tiến bộ học tập của học viên không? Có kiểm tra định kỳ không?', 'Chờ tư vấn'),
(10, 'Vũ Như Yên', '2025-06-15', '0365745697', 'Sinh viên', 'HN: 26 Nguyễn Thị Định, Trung Hòa, Cầu Giấy', 'Trung tâm có hỗ trợ tư vấn hoặc cung cấp tài liệu học thêm cho học viên không?', 'Chờ tư vấn'),
(14, 'Phạm Thị Ngân', '2025-06-17', '0364757489', 'Học sinh', NULL, 'Trung tâm có những khóa học nào phù hợp với trình độ cấp 3 của tôi ?', 'Chờ tư vấn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblxacnhan`
--

CREATE TABLE `tblxacnhan` (
  `maxacnhan` bigint(20) NOT NULL,
  `HoTen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `gioitinh` varchar(255) DEFAULT NULL,
  `Sdt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DiaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NgayGui` datetime DEFAULT NULL,
  `trangthai` varchar(255) DEFAULT NULL,
  `MaLop` int(11) DEFAULT NULL,
  `MaForm` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblxacnhan`
--

INSERT INTO `tblxacnhan` (`maxacnhan`, `HoTen`, `NgaySinh`, `gioitinh`, `Sdt`, `DiaChi`, `Email`, `NgayGui`, `trangthai`, `MaLop`, `MaForm`) VALUES
(1, 'Lê Văn Cừ', '2000-03-10 00:00:00', 'Nam', '0123987654', '05 Lê Văn Lương', 'levancuong@gmail.com', '2023-08-12 00:00:00', 'Hoàn thành', 1, 1),
(2, 'Phạm Thị Ngân', '2001-04-25 00:00:00', 'Nữ', '0123765498', '101 Huỳnh Thúc Kháng', 'phamthingan@gmail.com', '2023-07-25 00:00:00', 'Hoàn thành', 1, 2),
(3, 'Hoàng Văn Hùng', '2003-05-30 00:00:00', 'Nam', '0192837465', '23 Nguyễn Trãi', 'hoangvanhung@gmail.com', '2023-08-25 00:00:00', 'Hoàn thành', 1, 3),
(4, 'Mai Văn Hải', '2005-05-14 00:00:00', 'Nam', '0365846539', '24 Mai Hắc Đế', 'maivanhai@gmail.com', '2023-07-19 00:00:00', 'Hoàn thành', 1, 4),
(5, 'Chảo Cáo Nhàn', '2004-06-23 00:00:00', 'Nữ', '0453768463', '45 Nguyễn Trãi', 'hoangnhatmai@gmail.com.com', '2024-07-02 00:00:00', 'Hoàn thành', 2, 5),
(6, 'Nguyễn Văn Nghĩa', '2003-02-18 00:00:00', 'Nam', '0846583927', '23 Trần Nhân Tông', 'nguyenvannghia@gmail.com', '2024-06-28 00:00:00', 'Hoàn thành', 2, 6),
(7, 'Đỗ Anh Thư', '2002-08-24 00:00:00', 'Nữ', '064537562', '41 Hoàng Hoa Thám', 'doanhthu@gmail.com', '2024-07-12 00:00:00', 'Hoàn thành', 2, 7),
(8, 'Vũ Ngọc Trâm', '2003-07-28 00:00:00', 'Nữ', '0365745697', '11 Trần Hưng Đạo', 'vungoctram@gmail.com', '2024-07-19 00:00:00', 'Hoàn thành', 2, 8),
(9, 'Vũ Mạnh Hùng', '2003-05-28 00:00:00', 'Nam', '06453759', '135 Nguyễn Chí Thanhhh', 'vumanhhung@gmail.com', '2025-06-05 00:00:00', 'Hoàn Thành', 38, 9),
(13, 'chảo cáo nhàn', '2003-11-29 19:35:42', 'Nam', '0867898896', 'lao cai', 'nhan@gmail.com', '2024-11-29 19:35:42', 'Hoàn Thành', 35, 12),
(14, 'Nguyễn Thị Tâm', '2002-03-05 17:00:00', 'Nữ', '0325684539', 'Hà Nội', 'nguyenthitam@gmail.com', '2025-06-17 11:01:40', 'Hoàn Thành', 38, 15),
(15, 'Dương', '2002-02-05 00:00:00', 'Nam', '0453756496', 'Trà Đoài, Quang Trung, Thái ', 'duong@gmail.com', '2025-06-17 10:57:06', 'Chờ Xác Nhận', NULL, 13),
(16, 'Trần Phàm', '2004-03-08 17:00:00', 'Nam', '0265846593', 'Số 12, Nguyễn Trãi', 'tranpham@gmail.com', '2025-06-17 11:17:24', 'Hoàn Thành', 38, 18),
(17, 'Mai Lung Linh', '2002-03-06 17:00:00', 'Nữ', '0945365745', 'Hồ Gươm', 'mailunglinh@gmail.com', '2025-06-17 11:18:15', 'Hoàn Thành', 38, 19),
(18, 'Nguyễn Văn Long', '2001-11-13 17:00:00', 'Nam', '0275648694', 'Số 24, Trần Nhân Tông', 'nguyenvanlong@gmail.com', '2025-06-17 11:19:28', 'Hoàn Thành', 38, 20),
(19, 'Vũ Quang Vinh', '2005-10-11 17:00:00', 'Nam', '0264836594', 'Số 56, Trần Nhân Tông', 'vuquangminh@gmail.com', '2025-06-17 11:20:35', 'Hoàn Thành', 38, 21),
(20, 'Nguyễn Mai Linh', '2001-03-12 17:00:00', 'Nữ', '0365849573', '46 Nguyễn Chí Thanh', 'nguyenmailinh@gmail.com', '2025-06-17 11:22:04', 'Hoàn Thành', 38, 22),
(21, 'Phạm Văn Quang', '2004-06-08 17:00:00', 'Nam', '0364756385', '45 Hồ Tây', 'phamvanquang@gmail.com', '2025-06-17 11:22:59', 'Hoàn Thành', 38, 23),
(22, 'Vũ Như Yên', '2003-09-09 17:00:00', 'Nữ', '0362758435', '35 Nguyễn Chí Thanh', 'vunhuyen@gmail.com', '2025-06-17 11:24:30', 'Hoàn Thành', 38, 24),
(23, 'Nguyễn Anh Thư', '2004-08-03 17:00:00', 'Nữ', '0564836593', '46 Chùa Láng', 'doanhthu@gmail.com', '2025-06-17 11:33:58', 'Hoàn Thành', 38, 25),
(24, 'Vũ Văn Thái', '2006-08-07 17:00:00', 'Nam', '0453859365', '34 Cầu Giấy', 'vuvanthai@gmail.com', '2025-06-17 11:35:29', 'Hoàn Thành', 38, 26),
(25, 'Nguyễn Đăng Đan', '2000-06-01 00:00:00', 'Nam', '0453756384', 'Chùa Láng', 'nguyendangdan@gmail.com', '2025-06-17 11:12:07', 'Chờ Xác Nhận', NULL, 17),
(26, 'Trần Văn Hoàng', '2005-03-07 17:00:00', 'Nam', '0234567934', '34 Hồ Tây', 'tranvanhoang@gmail.com', '2025-06-17 11:54:06', 'Hoàn Thành', 40, 27),
(27, 'Vũ Văn Nghĩa', '2004-03-08 17:00:00', 'Nam', '0374628576', '56 Mai Hắc Đế', 'vuvannghia@gmail.com', '2025-06-17 11:55:36', 'Hoàn Thành', 41, 28),
(28, 'Trần Minh Thư', '2004-07-07 00:00:00', 'Nữ', '0453756457', 'Hồ Tây', 'tranminhthu@gmail.com', '2025-06-17 10:59:20', 'Hoàn Thành', 42, 14);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblcauhoithithu`
--
ALTER TABLE `tblcauhoithithu`
  ADD PRIMARY KEY (`MaCauHoi`),
  ADD KEY `fk_doan_cauhoi_idx` (`MaDoan`);

--
-- Chỉ mục cho bảng `tblchucvu`
--
ALTER TABLE `tblchucvu`
  ADD PRIMARY KEY (`MaChucVu`),
  ADD KEY `MaLoaiChucVu` (`MaLoaiChucVu`);

--
-- Chỉ mục cho bảng `tbldiemdanh`
--
ALTER TABLE `tbldiemdanh`
  ADD PRIMARY KEY (`MaDiemDanh`),
  ADD KEY `MaNguoiDung` (`MaNguoiDung`),
  ADD KEY `MaLop` (`MaLop`);

--
-- Chỉ mục cho bảng `tbldoanthi`
--
ALTER TABLE `tbldoanthi`
  ADD PRIMARY KEY (`MaDoan`);

--
-- Chỉ mục cho bảng `tblformnhaphoc`
--
ALTER TABLE `tblformnhaphoc`
  ADD PRIMARY KEY (`MaForm`);

--
-- Chỉ mục cho bảng `tblketquathithu`
--
ALTER TABLE `tblketquathithu`
  ADD PRIMARY KEY (`MaKetQua`),
  ADD KEY `fk_form_thithu_idx` (`MaForm`),
  ADD KEY `fk_cauhoi_thithu_idx` (`MaCauHoi`);

--
-- Chỉ mục cho bảng `tblkhoahoc`
--
ALTER TABLE `tblkhoahoc`
  ADD PRIMARY KEY (`MaKhoaHoc`);

--
-- Chỉ mục cho bảng `tblloaichucvu`
--
ALTER TABLE `tblloaichucvu`
  ADD PRIMARY KEY (`MaLoaiChucVu`);

--
-- Chỉ mục cho bảng `tbllophoc`
--
ALTER TABLE `tbllophoc`
  ADD PRIMARY KEY (`MaLop`),
  ADD KEY `MaKhoaHoc` (`MaKhoaHoc`);

--
-- Chỉ mục cho bảng `tblnguoidung`
--
ALTER TABLE `tblnguoidung`
  ADD PRIMARY KEY (`MaNguoiDung`),
  ADD KEY `fk_machucvu` (`machucvu`);

--
-- Chỉ mục cho bảng `tblnguoi_lophoc`
--
ALTER TABLE `tblnguoi_lophoc`
  ADD PRIMARY KEY (`MaNguoiDung`,`MaLop`) USING BTREE,
  ADD KEY `MaLop` (`MaLop`);

--
-- Chỉ mục cho bảng `tblphonghoc`
--
ALTER TABLE `tblphonghoc`
  ADD PRIMARY KEY (`MaPhong`);

--
-- Chỉ mục cho bảng `tbltkb`
--
ALTER TABLE `tbltkb`
  ADD PRIMARY KEY (`matkb`),
  ADD KEY `MaPhong` (`MaPhong`),
  ADD KEY `fk_MaLop` (`MaLop`);

--
-- Chỉ mục cho bảng `tbltuvan`
--
ALTER TABLE `tbltuvan`
  ADD PRIMARY KEY (`matuvan`);

--
-- Chỉ mục cho bảng `tblxacnhan`
--
ALTER TABLE `tblxacnhan`
  ADD PRIMARY KEY (`maxacnhan`),
  ADD KEY `MaForm` (`MaForm`),
  ADD KEY `MaLop` (`MaLop`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tblcauhoithithu`
--
ALTER TABLE `tblcauhoithithu`
  MODIFY `MaCauHoi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT cho bảng `tblchucvu`
--
ALTER TABLE `tblchucvu`
  MODIFY `MaChucVu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `tbldiemdanh`
--
ALTER TABLE `tbldiemdanh`
  MODIFY `MaDiemDanh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145;

--
-- AUTO_INCREMENT cho bảng `tbldoanthi`
--
ALTER TABLE `tbldoanthi`
  MODIFY `MaDoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `tblformnhaphoc`
--
ALTER TABLE `tblformnhaphoc`
  MODIFY `MaForm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `tblketquathithu`
--
ALTER TABLE `tblketquathithu`
  MODIFY `MaKetQua` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;

--
-- AUTO_INCREMENT cho bảng `tblkhoahoc`
--
ALTER TABLE `tblkhoahoc`
  MODIFY `MaKhoaHoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `tblloaichucvu`
--
ALTER TABLE `tblloaichucvu`
  MODIFY `MaLoaiChucVu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `tbllophoc`
--
ALTER TABLE `tbllophoc`
  MODIFY `MaLop` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT cho bảng `tblnguoidung`
--
ALTER TABLE `tblnguoidung`
  MODIFY `MaNguoiDung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT cho bảng `tblphonghoc`
--
ALTER TABLE `tblphonghoc`
  MODIFY `MaPhong` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `tbltkb`
--
ALTER TABLE `tbltkb`
  MODIFY `matkb` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT cho bảng `tbltuvan`
--
ALTER TABLE `tbltuvan`
  MODIFY `matuvan` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `tblxacnhan`
--
ALTER TABLE `tblxacnhan`
  MODIFY `maxacnhan` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tblcauhoithithu`
--
ALTER TABLE `tblcauhoithithu`
  ADD CONSTRAINT `fk_doan_cauhoi` FOREIGN KEY (`MaDoan`) REFERENCES `tbldoanthi` (`MaDoan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tblchucvu`
--
ALTER TABLE `tblchucvu`
  ADD CONSTRAINT `tblchucvu_ibfk_1` FOREIGN KEY (`MaLoaiChucVu`) REFERENCES `tblloaichucvu` (`MaLoaiChucVu`);

--
-- Các ràng buộc cho bảng `tbldiemdanh`
--
ALTER TABLE `tbldiemdanh`
  ADD CONSTRAINT `tbldiemdanh_ibfk_1` FOREIGN KEY (`MaNguoiDung`) REFERENCES `tblnguoidung` (`MaNguoiDung`),
  ADD CONSTRAINT `tbldiemdanh_ibfk_2` FOREIGN KEY (`MaLop`) REFERENCES `tbllophoc` (`MaLop`);

--
-- Các ràng buộc cho bảng `tblketquathithu`
--
ALTER TABLE `tblketquathithu`
  ADD CONSTRAINT `fk_cauhoi_thithu` FOREIGN KEY (`MaCauHoi`) REFERENCES `tblcauhoithithu` (`MaCauHoi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_form_thithu` FOREIGN KEY (`MaForm`) REFERENCES `tblformnhaphoc` (`MaForm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tbllophoc`
--
ALTER TABLE `tbllophoc`
  ADD CONSTRAINT `tbllophoc_ibfk_1` FOREIGN KEY (`MaKhoaHoc`) REFERENCES `tblkhoahoc` (`MaKhoaHoc`);

--
-- Các ràng buộc cho bảng `tblnguoidung`
--
ALTER TABLE `tblnguoidung`
  ADD CONSTRAINT `fk_machucvu` FOREIGN KEY (`machucvu`) REFERENCES `tblchucvu` (`MaChucVu`);

--
-- Các ràng buộc cho bảng `tblnguoi_lophoc`
--
ALTER TABLE `tblnguoi_lophoc`
  ADD CONSTRAINT `tblnguoi_lophoc_ibfk_1` FOREIGN KEY (`MaLop`) REFERENCES `tbllophoc` (`MaLop`),
  ADD CONSTRAINT `tblnguoi_lophoc_ibfk_2` FOREIGN KEY (`MaNguoiDung`) REFERENCES `tblnguoidung` (`MaNguoiDung`);

--
-- Các ràng buộc cho bảng `tbltkb`
--
ALTER TABLE `tbltkb`
  ADD CONSTRAINT `fk_MaLop` FOREIGN KEY (`MaLop`) REFERENCES `tbllophoc` (`MaLop`),
  ADD CONSTRAINT `tbltkb_ibfk_1` FOREIGN KEY (`MaPhong`) REFERENCES `tblphonghoc` (`MaPhong`);

--
-- Các ràng buộc cho bảng `tblxacnhan`
--
ALTER TABLE `tblxacnhan`
  ADD CONSTRAINT `tblxacnhan_ibfk_1` FOREIGN KEY (`MaForm`) REFERENCES `tblformnhaphoc` (`MaForm`),
  ADD CONSTRAINT `tblxacnhan_ibfk_2` FOREIGN KEY (`MaLop`) REFERENCES `tbllophoc` (`MaLop`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
