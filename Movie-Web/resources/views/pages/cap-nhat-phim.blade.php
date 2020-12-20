@extends('layouts.default')
@section('noi-dung')

<section class="wrapper">
    <div class="container">
        <h2 class="title-h2 text-center add-movie">CHỈNH SỬA PHIM</h2>
        <div class="fb-w-40 d-in-bl f-left ">
            <form>
                <div class="form-group">
                    <label for="txtname">Tên phim</label>
                    <input type="text" class="form-control" id="txtname" placeholder="Nhập tên phim">
                    <small id="namemovie" class="form-text text-danger"> Vui lòng nhập tên phim!</small>
                  </div>
            </form>
            <div class="form-group">
                <label for="select-theloai">Thể loại</label>
                <select class="form-control" id="select-theloai">
                  <option>Hành động</option>
                  <option>Hài</option>
                  <option>Tình cảm</option>
                  <option>Tâm lí</option>
                  <option>Viễn tưởng</option>
                </select>
            </div>
           
            <div class="form-group">
                <label for="noidung">Tóm tắt nội dung</label>
                <textarea class="form-control" id="noidung" rows="8"></textarea>
                <small id="noidung" class="form-text text-danger"> Vui lòng nhập nội dung phim!</small>
              </div>
            </form>
            <form>
                <div class="form-group">
                  <label for="poster">Tải ảnh lên</label>
                  <input type="file" class="form-control-file" id="poster">
                </div>
              </form>
        </div>
        <div class="fb-w-40 d-in-bl f-right">
            <form>
                <div class="form-group">
                    <label for="txtthoiluong">Thời lượng</label>
                    <input type="text" class="form-control" id="txtname" placeholder="Thời lượng">
                    <small id="thoiluong" class="form-text text-danger"> Vui lòng nhập thời lượng!</small>
                  </div>
            </form>
            <div class="form-group">
                <label for="select-tuoi">Độ tuổi</label>
                <select class="form-control" id="select-tuoi">
                  <option>18+</option>
                  <option>14+</option>
                  <option>16+</option>
                  <option>10+</option>
                </select>
            </div>
            <form>
                <div class="form-group">
                    <label for="txtkhoichieu">Khởi chiếu</label>
                    <input type="date" class="form-control" id="txtkhoichieu" placeholder="Thời lượng">
                    <small id="khoichieu" class="form-text text-danger">Ngày không hợp lệ!</small>
                  </div>
            </form>
            <form>
                <div class="form-group">
                    <label for="txttrailer">Trailer</label>
                    <input type="text" class="form-control" id="txttrailer" placeholder="Thời lượng">
                    <small id="trailer" class="form-text text-danger">Vui lòng thêm trailer!</small>
                  </div>
            </form>
        </div>
    </div>
</section>

@endsection