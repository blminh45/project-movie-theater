@extends('layouts.default')
@section('noi-dung')

<section class="wrapper">
    <h2 class="text-center title-h2">DANH SÁCH PHIM</h2>
    <form class="form-inline bg-dark search-tv" action="">
        <input class="form-control mr-2" type="text" placeholder="Search">
        <button class="btn btn-success" type="submit">Search</button>
    </form>
        <table class="table table-all">
            <thead class="thead-dark table-all-dark">
                <tr>
                    <th>STT</th>
                    <th>Hình ảnh</th>
                    <th>Tên phim</th>
                    <th>Thể loại</th>
                    <th>Độ tuổi</th>
                    <th>Thời lượng</th>
                    <th>Công chiếu</th>
                    <th>Update</th>
                    <th>Delete</th>
                    <th>Lịch chiếu</th>
                </tr>
            </thead>
            <tbody>
                @for($i=0;$i<15;$i++) 
                <tr>
                    <th>{{ $i+1 }}</th>
                    <td class="poster"><img src="https://d1j8r0kxyu9tj8.cloudfront.net/images/1566809317niNpzY2khA3tzMg.jpg" alt="" ></td>
                    <td>Lưỡi gươm diệt quỷ</td>
                    <td>Anime</td>
                    <td>18+</td>
                    <td>114 Phút</td>
                    <td>08-12-2020</td>
                    <td><button class="btn btn-warning">Update</button></td>
                    <td><button class="btn btn-secondary"
                            style="background-color: #606060; color: #fff;">Delete</button></td>
                    <td><button class="btn btn-info">Lịch chiếu</button></td>
                </tr>
             @endfor
            </tbody>
        </table>
</section>

<!-- footer -->
{{-- @include('includes.footer') --}}
<!-- / footer -->

@endsection