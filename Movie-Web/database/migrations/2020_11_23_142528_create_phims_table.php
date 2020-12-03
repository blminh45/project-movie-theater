<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePhimsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('phims', function (Blueprint $table) {
            $table->id();
            $table->string('ten_phim');
            $table->string('hinh_anh')->nullable();
            $table->integer('id_the_loai')->unsigned();
            $table->float('thoi_luong');
            $table->date('khoi_chieu')->nullable();
            $table->string('tom_tat')->nullable();
            $table->string('trailer')->nullable();
            $table->boolean('trang_thai');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phims');
    }
}
