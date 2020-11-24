<?php

use Illuminate\Database\Seeder;

class TheLoaiSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('the_loais')->insert([
            ['ten_the_loai'=>'tình cảm'],
            ['ten_the_loai'=>'học đường'],
            ['ten_the_loai'=>'siêu nhiên'],
            ['ten_the_loai'=>'hài hước'],
            ['ten_the_loai'=>'tâm lý']
        ]);
    }
}