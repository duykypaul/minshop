use minshop;
create table CHUCVU(
	machucvu integer not null auto_increment,
    tenchucvu nvarchar(20),
    primary key(machucvu)
);

create table NHANVIEN (
	manhanvien integer not null auto_increment,
    tendangnhap varchar(50) not null,
    matkhau varchar(16) not null,
    hoten nvarchar(30),
    diachi nvarchar(100),
    gioitinh bit,
    cmnd char(14),
    email varchar(50),
    sdt varchar(12),
    machucvu integer not null,
    primary key(manhanvien),
    constraint FK_NHANVIEN_CHUCVU foreign key(machucvu) references CHUCVU(machucvu)
);

create table DANHMUCSANPHAM (
	madanhmuc integer not null auto_increment,
    tendanhmuc nvarchar(50),
    hinhanhdanhmuc nvarchar(30),
    primary key(madanhmuc)
);

create table SANPHAM (
	masanpham integer not null auto_increment,
    tensanpham nvarchar(100) not null,
    giatien integer,
    mota nvarchar(100),
    hinhanhsanpham nvarchar(30),
    madanhmuc integer not null,
    primary key(masanpham),
    constraint FK_SANPHAM_DANHMUCSANPHAM foreign key(madanhmuc) references DANHMUCSANPHAM(madanhmuc)
);

create table MAUSANPHAM (
	mamau integer not null auto_increment,
    tenmau nvarchar(20),
    primary key(mamau)
);

create table SIZESANPHAM (
	masize integer not null auto_increment,
    size varchar(10),
    primary key(masize)
);

create table CHITIETSANPHAM (
	machitietsanpham integer not null auto_increment,
    masanpham integer,
    masize integer, 
    mamau integer,
    soluong integer,
    ngaynhap varchar(20),
    primary key(machitietsanpham),
    constraint FK_CHITIETSANPHAM_SANPHAM foreign key(masanpham) references SANPHAM(masanpham),
    constraint FK_CHITIETSANPHAM_SIZESANPHAM foreign key(masize) references SIZESANPHAM(masize),
    constraint FK_CHITIETSANPHAM_MAUSANPHAM foreign key(mamau) references MAUSANPHAM(mamau)
);

create table KHUYENMAI (
	makhuyenmai integer not null auto_increment,
    tenkhuyenmai nvarchar(50),
    thoigianbatdau nvarchar(50),
    thoigianketthuc nvarchar(50),
    mota text,
    hinhanhkhuyenmai text,
    giagiam integer,
    primary key(makhuyenmai)
);


create table CHITIETKHUYENMAI(
	makhuyenmai integer not null auto_increment,
    masanpham integer not null,
    primary key(makhuyenmai, masanpham),
    constraint FK_CHITIETKHUYENMAI_KHUYENMAI foreign key(makhuyenmai) references KHUYENMAI(makhuyenmai),
    constraint FK_CHITIETKHUYENMAI_SANPHAM foreign key(masanpham) references SANPHAM(masanpham)
);

create table HOADON (
	mahoadon integer not null auto_increment,
    tenkhachhang nvarchar(50),
    sdt nvarchar(12),
    diachigiaohang nvarchar(100),
    tinhtrang bit,
    ngaylap nvarchar(50),
    primary key(mahoadon)
);

create table CHITIETHOADON (
	mahoadon integer not null,
    machitietsanpham integer not null,
    soluong integer,
    giatien varchar(100),
    primary key(mahoadon, machitietsanpham),
    constraint FK_CHITIETHOADON_HOADON foreign key(mahoadon) references HOADON(mahoadon),
    constraint FK_CHITIETHOADON_CHITIETSANPHAM foreign key(machitietsanpham) references CHITIETSANPHAM(machitietsanpham)
);