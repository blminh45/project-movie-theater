<?php

use Illuminate\Database\Seeder;

class PhimSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('phims')->insert([
            [ 'ten_phim'=>'Koe no katachi', 'id_the_loai'=>1, 'thoi_luong'=>130 ],
            [ 'ten_phim'=>'Kimi no na wa', 'id_the_loai'=>2, 'thoi_luong'=>106 ],
            [ 'ten_phim'=>'Kaguya-sama: Love is war', 'id_the_loai'=>5, 'thoi_luong'=>24 ]
        ]);
    }
}
