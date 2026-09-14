// MongoDB Playground - importera testbilder till targetPaintings
use('calmpainter');

const paintings = [
   {
  name: "Four Color Kite",
  grid: {
    cells: [
      [null, null, null, null, null, null, null, "BLUE", null, null, null, null, null, null, null],
      [null, null, null, null, null, null, "BLUE", "BLUE", "RED", null, null, null, null, null, null],
      [null, null, null, null, null, "BLUE", "BLUE", "BLUE", "RED", "RED", null, null, null, null, null],
      [null, null, null, null, "BLUE", "BLUE", "BLUE", "BLUE", "RED", "RED", "RED", null, null, null, null],
      [null, null, null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", "RED", "RED", "RED", "RED", null, null, null],
      [null, null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", "RED", "RED", "RED", "RED", "RED", null, null],
      [null, null, null, "GREEN", "GREEN", "GREEN", "GREEN", "GREEN", "YELLOW", "YELLOW", "YELLOW", "YELLOW", null, null, null],
      [null, null, null, null, "GREEN", "GREEN", "GREEN", "GREEN", "YELLOW", "YELLOW", "YELLOW", null, null, null, null],
      [null, null, null, null, null, "GREEN", "GREEN", "GREEN", "YELLOW", "YELLOW", null, null, null, null, null],
      [null, null, null, null, null, null, "GREEN", "GREEN", "YELLOW", null, null, null, null, null, null],
      [null, null, null, null, null, null, null, "GREEN", null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, "GREEN", null, null, null, null, null, null, null],
      [null, null, null, null, null, null, "RED", "RED", "RED", null, null, null, null, null, null],
      [null, null, null, null, null, null, null, "YELLOW", null, null, null, null, null, null, null],
      [null, null, null, null, null, null, "BLUE", "BLUE", "BLUE", null, null, null, null, null, null]
    ]
  }
},
{
  name: "Flower in Blue Pot",
  grid: {
    cells: [
      [null, null, null, null, null, "RED", "RED", null, "RED", "RED", null, null, null, null, null],
      [null, null, null, null, "RED", "RED", "RED", "YELLOW", "RED", "RED", "RED", null, null, null, null],
      [null, null, null, "RED", "RED", "RED", "YELLOW", "YELLOW", "YELLOW", "RED", "RED", "RED", null, null, null],
      [null, null, null, "RED", "RED", "RED", "YELLOW", "YELLOW", "YELLOW", "RED", "RED", "RED", null, null, null],
      [null, null, null, null, "RED", "RED", "RED", "YELLOW", "RED", "RED", "RED", null, null, null, null],
      [null, null, null, null, null, "RED", "RED", "RED", "RED", "RED", null, null, null, null, null],
      [null, null, null, null, null, null, null, "GREEN", null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, "GREEN", null, null, "GREEN", null, null, null, null],
      [null, null, null, null, null, null, null, "GREEN", "GREEN", "GREEN", "GREEN", null, null, null, null],
      [null, null, null, null, "GREEN", "GREEN", "GREEN", "GREEN", null, null, null, null, null, null, null],
      [null, null, null, null, null, null, "GREEN", "GREEN", null, null, null, null, null, null, null],
      [null, null, null, null, null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", null, null, null, null, null],
      [null, null, null, null, null, null, "BLUE", "BLUE", "BLUE", null, null, null, null, null, null],
      [null, null, null, null, null, null, "BLUE", "BLUE", "BLUE", null, null, null, null, null, null],
      [null, null, null, null, null, null, "BLUE", "BLUE", "BLUE", null, null, null, null, null, null]
    ]
  }
},
{
  name: "Four Color Rainbow",
  grid: {
    cells: [
      [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null],
      [null, null, null, null, null, "RED", "RED", "RED", "RED", "RED", null, null, null, null, null],
      [null, null, null, "RED", "RED", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "RED", "RED", null, null, null],
      [null, null, "RED", "YELLOW", "YELLOW", "GREEN", "GREEN", "GREEN", "GREEN", "GREEN", "YELLOW", "YELLOW", "RED", null, null],
      [null, "RED", "YELLOW", "GREEN", "GREEN", "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", "GREEN", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, "RED", "YELLOW", "GREEN", "BLUE", null, null, null, null, null, "BLUE", "GREEN", "YELLOW", "RED", null],
      [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null],
      [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
    ]
  }
},
{
  name: "Red Sailboat",
  grid: {
    cells: [
      [null, null, null, null, null, null, null, null, "GREEN", "GREEN", "GREEN", null, null, null, null],
      [null, "YELLOW", "YELLOW", "YELLOW", null, null, null, null, "GREEN", "GREEN", null, null, null, null, null],
      ["YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", null, null, null, "RED", null, null, null, null, null, null],
      [null, "YELLOW", "YELLOW", "YELLOW", null, null, null, "RED", "RED", null, null, null, null, null, null],
      [null, null, null, null, null, null, "RED", "RED", "RED", null, null, null, null, null, null],
      [null, null, null, null, null, "RED", "RED", "RED", "RED", null, null, null, null, null, null],
      [null, null, null, null, "RED", "RED", "RED", "RED", "RED", null, null, null, null, null, null],
      [null, null, null, "RED", "RED", "RED", "RED", "RED", "RED", null, null, null, null, null, null],
      [null, null, "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", null, null, null, null],
      [null, null, null, "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", "YELLOW", null, null, null, null, null],
      ["BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE"],
      [null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE"],
      ["BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", null],
      [null, "BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE"],
      ["BLUE", "BLUE", "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", null, "BLUE", "BLUE", "BLUE", "BLUE", "BLUE"]
    ]
  }
}
  
];

db.targetPaintings.insertMany(paintings);