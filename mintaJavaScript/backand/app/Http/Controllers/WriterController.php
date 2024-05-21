<?php

namespace App\Http\Controllers;

use App\Models\Writer;
use Illuminate\Http\Request;

class WriterController extends Controller
{
    public function index()
    {
        $writers = Writer::all();
        return response()->json($writers);
    }

    public function store(Request $request)
    {
        $record = new Writer();
        $record->nev = $request->nev;
        $record->szul = $request->szul;
        $record->save();

        return Writer::find($record->id);
    }

    public function destroy($id)
    {
        $writer = Writer::find($id)->delete();
        return response()->json(['message'=>'Sikeres törlés'],201);
    }

    public function update(Request $request, $id)
    {
        $users = Writer::find($id);
        $users->nev = $request->nev;
        $users->szul = $request->szul;
        $users->save();

        return Writer::find('/writer');
    }
}
