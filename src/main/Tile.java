package main;

import java.util.ArrayList;
import java.util.List;

/**
 * A mező ősosztály, ami a tárolja, hogy melyik virológusok vannak rajta és hogy mennyi
 * virológus lehet a mezőn. A feladata a szomszédos mezők tárolása és a virológusok mezőn
 * való tartózkodásának kezelése.
 */
public class Tile {
	protected int id;
	protected long capacity;
	protected ArrayList<Tile> adjacentTiles;
	protected ArrayList<Virologist> virologists;

	/**
	 * Egy mező konstruktora
	 */
	public Tile(){
		capacity = 2;
		adjacentTiles = new ArrayList<Tile>();
		virologists = new ArrayList<Virologist>();
	}

	/**
	 * Eltávolítja az adott mezőről a virológust.
	 * @param v Az a virológus, aki ellép
	 */
	public void Remove(Virologist v) {
		virologists.remove(v);
	}

	/**
	 * Beteszi az adott mezőre a virológust.
	 * @param v Az a virológus, aki odalép
	 */
	public void Accept(Virologist v) {
		if(virologists.size() < capacity){
			virologists.add(v);
		}
	}

	/**
	 * Megadja az n-edik szomszédos mezőt.
	 * @param n a mező száma
	 * @return A szomszédos mező
	 */
	public Tile GetNeighbor(long n) {
		return adjacentTiles.get((int)n);
	}

	/**
	 * Beállítja a szomszédos mezőt
	 * @param tile a szomszédos mező
	 */
	public void setNeighbor(Tile tile){
		adjacentTiles.add(tile);
	}

	/**
	 * Visszaadja a másik virológust a mezőről
	 * @param v a mi virológusunk
	 * @return a másik virológus
	 */
	public Virologist GetOtherVirologist(Virologist v) {
		if(virologists.size() > 1){
			for( Virologist virologist : virologists){
				if(virologist != v){
					return virologist;
				}
			}
		}
		return null;
	}

	/**
	 * Beállítja a felvehető tárgyat/kódot
	 * @param o
	 */
	public void setCollectable(Object o){ }

	/**
	 * Megmondja, hogy milyen gyűjthető objektum van a mezőn
	 * @return a felvehető tárgy/kód
	 */
	public Object GetCollectable(){
		return null;
	}

	/**
	 * Visszaadja a az osztály azonosítóját
	 * @return id: azonosító szám
	 */
	public int getId(){
		return id;
	}

	/**
	 * Beállítja, hogy mennyi az id-je
	 * @param id a a kapott id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Kiírja az osztály attribútumainak értékeit
	 */
	public void Print(){
		System.out.println("Tile:");
		System.out.print("\tadjacentTiles: ");
		if(virologists.size() != 0){
			for(int i = 0; i < virologists.size(); i++)
				System.out.print(virologists.get(i).getId() + ". virologist ");
			System.out.println("");
		}
		if(virologists.size() == 0)
			System.out.println("null");
		System.out.println("");
	}
}
