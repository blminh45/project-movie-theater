<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        //$this->middleware('auth');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Contracts\Support\Renderable
     */
    public function index()
    {
        return view('home');
    }

    public function danh_sach_phim()
    {
        return view('pages.danh-sach-phim');
    }

    public function them_phim()
    {
        return view('pages.them-phim');
    }

    public function cap_nhat_phim()
    {
        return view('pages.cap-nhat-phim');
    }

    public function danh_sach_rap() 
    {
        return view('pages.danh-sach-rap');
    }

    public function danh_sach_thanh_vien()
    {
        return view('pages.danh-sach-thanh-vien');
    }
}
