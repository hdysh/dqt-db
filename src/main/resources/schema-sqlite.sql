DROP TABLE IF EXISTS unit;
DROP TABLE IF EXISTS stats;
DROP TABLE IF EXISTS rarity;
DROP TABLE IF EXISTS skill_rarity;
DROP TABLE IF EXISTS element;
DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS family;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS res_level;
DROP TABLE IF EXISTS ele_res;
DROP TABLE IF EXISTS ail_res;
DROP TABLE IF EXISTS ailment;;
DROP TABLE IF EXISTS passive;
DROP TABLE IF EXISTS master;
DROP TABLE IF EXISTS unit_rate;
DROP TABLE IF EXISTS stage;
DROP TABLE IF EXISTS drops;
DROP TABLE IF EXISTS drops_map;
DROP TABLE IF EXISTS enemy;
DROP TABLE IF EXISTS enemies_map;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS event_portal;
DROP TABLE IF EXISTS event_area;
DROP TABLE IF EXISTS event_group;
DROP TABLE IF EXISTS mission;
DROP TABLE IF EXISTS mission_list;
DROP TABLE IF EXISTS unit_drop;

CREATE TABLE unit  ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	name TEXT,
	family INTEGER,
	role INTEGER,
	rarity INTEGER,
	icon TEXT,
	ailres INTEGER,
	leader ,  
weight INTEGER,	
	unique(code)
);
 CREATE TABLE stats (
 	id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER, 
    level INTEGER,
    hp INTEGER,
    mp INTEGER,
    attack INTEGER,
    defense INTEGER,
    intelligence INTEGER,
    agility INTEGER,
    mobility INTEGER,
    rank INTEGER, 
	move INTEGER,
    stype TEXT,    
    unique(code,rank)
); 
CREATE TABLE skill ( 
	id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,
    name TEXT,
    description TEXT,
	icon TEXT,
	button TEXT,
    rarity INTEGER,
    base_damage INTEGER,
    min_damage INTEGER,
    max_damage INTEGER,
    accuracy INTEGER,
    mp INTEGER,
	range TEXT,
	reach TEXT,
    element INTEGER,
    multiplier INTEGER,
    max_mul INTEGER,
	pc INTEGER,    
	usage INTEGER,
	turn INTEGER,
	active_skill_action INTEGER, 
	active_skill INTEGER, 
	active_skill_target INTEGER,  
	damage_calculation INTEGER,
	unique(code)
);

CREATE TABLE rarity ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	name TEXT,
	icon TEXT,
	frame TEXT,
	background TEXT,
	unique(code)
);

CREATE TABLE skill_rarity ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	name TEXT,
	icon TEXT, 
	background TEXT,
	unique(code)
);

CREATE TABLE role ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	name TEXT,
	icon TEXT,
	unique(code)
);
CREATE TABLE family ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	name TEXT,
	icon TEXT,
	unique(code)
);

 CREATE TABLE element ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	name TEXT,
	icon TEXT,
	unique(code)
);
CREATE TABLE ailment ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	res INTEGER, 
	name TEXT,
	display_format TEXT,
	desc_format TEXT,
	icon TEXT,
	unique(code)
);
CREATE TABLE ailment_res ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,  
	name TEXT, 
	icon TEXT,
	unique(code)
);
CREATE TABLE level_status ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,  
	level INTEGER, 
	value INTEGER,
	icon TEXT,
	unique(code,level)
);
 CREATE TABLE res_level ( 
	id INTEGER PRIMARY KEY NOT NULL,
	minv INTEGER, 
	maxv INTEGER, 
	icon TEXT,
	unique(minv,maxv)
);
CREATE TABLE ele_res ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,
    ele1 INTEGER, 
    ele2 INTEGER, 
    ele3 INTEGER, 
    ele4 INTEGER, 
    ele5 INTEGER, 
    ele6 INTEGER, 
    ele7 INTEGER,
	unique(code)
);
CREATE TABLE unit_ail_res ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,
    ail1 INTEGER,
    ail2 INTEGER,
    ail3 INTEGER,
    ail4 INTEGER,
    ail5 INTEGER,
    ail6 INTEGER,
    ail7 INTEGER,
    ail8 INTEGER,
    ail9 INTEGER,
    ail10 INTEGER,
    ail11 INTEGER,
    ail12 INTEGER,
    ail13 INTEGER,
    ail14 INTEGER,
	unique(code)
);
CREATE TABLE passive ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	name TEXT,
	description TEXT,
	stats INTEGER,
	eleres INTEGER,
	leadericon TEXT,
	var TEXT,
	unique(code)
);
CREATE TABLE master ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER, 
    stats INTEGER ,
	unique(code)
);
CREATE TABLE unit_rate ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER, 
    rate INTEGER ,
	unique(code)
); 
CREATE TABLE stage ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER, 
    name TEXT,
    enemies INTEGER[],
    drops INTEGER[],
    firstdrops INTEGER[],
    cp INTEGER,
    stamina INTEGER,
    area INTEGER,
    icon TEXT,
    missionlist INTEGER,
	unique(code)
); 

CREATE TABLE drops ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,  
    item INTEGER,
    quantity INTEGER, 
    minroll INTEGER, 
    maxroll INTEGER, 
    rate INTEGER, 
	slot INTEGER,
    first boolean
); 

CREATE TABLE drops_map ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,  
    stage INTEGER,  
    dropi INTEGER ,
	unique(code,dropi)
); 

CREATE TABLE enemy ( 
 id INTEGER PRIMARY KEY NOT NULL,
   code INTEGER,
    name TEXT, 
    icon TEXT, 
    rarity TEXT, 
    resfrizz INTEGER,
    ressizz INTEGER,
    rescrack INTEGER,
    reswosh INTEGER,
    resbang INTEGER,
    reszap INTEGER,
    reszam INTEGER,
    ailres INTEGER,   
    base INTEGER,
	unique(code)
); 
CREATE TABLE enemies_map ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,  
    stage INTEGER,  
    enemy INTEGER,
	unique(code)
); 
CREATE TABLE item ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,  
    name TEXT,
    description TEXT,
    icon TEXT,
    rank INTEGER,
	unique(code)
); 
CREATE TABLE event_area ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,  
	name TEXT,  
	icon TEXT,  
	areagroup INTEGER,
	eventportal INTEGER,
	category INTEGER,
	sub_category INTEGER,
	unique(code)
); 
CREATE TABLE event_portal ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,  
	name TEXT,  
	description TEXT,  
	icon TEXT,
	achievement INTEGER,
	shop INTEGER,
	reminiscence INTEGER,	
	unique(code)
);  
CREATE TABLE event_group ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,  
	name TEXT,    
	icon TEXT, 
	eventportal INTEGER,
	category INTEGER,
	sub_category INTEGER,
	unique(code)
);  
CREATE TABLE mission ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,  
    reward INTEGER,  
    quantity INTEGER,
    condition TEXT,
    num TEXT,
    obj TEXT,
	unique(code)
);  

CREATE TABLE mission_list ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,    
    mission1 INTEGER, 
    mission2 INTEGER, 
    mission3 INTEGER ,
	unique(code)
);  
CREATE TABLE unit_drop ( 
 id INTEGER PRIMARY KEY NOT NULL,
    code INTEGER,  
    uid INTEGER,    
    unit TEXT, 
    stage TEXT, 
    portal TEXT, 
    rate INTEGER,
    stamina INTEGER ,
	unique(code)
);  

CREATE TABLE unit_skill (
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	level INTEGER,
	skill INTEGER,
    unique(code,skill)
);
CREATE TABLE unit_passive (
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	level INTEGER,
	passive INTEGER,
    unique(code,passive,level)
);
CREATE TABLE unit_awakening (
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER,
	level INTEGER,
	awakening INTEGER,
    unique(code,awakening,level)
);

CREATE TABLE unit_ele_res ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	frizz INTEGER,
	sizz INTEGER,
	crack INTEGER,
	woosh INTEGER,
	bang INTEGER,
	zap INTEGER,
	zam INTEGER,
	unique(code)
);
CREATE TABLE panel_content ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	name TEXT,
	desc TEXT,
	icon TEXT,
	bg TEXT,
	stype INTEGER,
	unique(code)
);
CREATE TABLE unit_talent ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	no INTEGER,
	ail_res INTEGER,
	ele_res INTEGER,
	skill INTEGER,
	stats INTEGER,   
	unique(code,no)
);
CREATE TABLE lang ( 
	id INTEGER ,
	name TEXT PRIMARY KEY NOT NULL,
	en TEXT,
	ja TEXT 
);
CREATE TABLE buff ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	name TEXT,   
	display_format TEXT,   
	desc_format TEXT,     
	suffix_up TEXT,     
	suffix_down TEXT, 
	status_change INTEGER, 
	status_change_override INTEGER,	
	unique(code)
);
CREATE TABLE skill_buff ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	buff INTEGER,   
	accuracy INTEGER,
	level INTEGER,
	min_dur INTEGER,
	max_dur INTEGER,
	unique(code,buff)
);
CREATE TABLE skill_ailment ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	ailment INTEGER,   
	accuracy INTEGER, 
	min_dur INTEGER,
	max_dur INTEGER,
	unique(code,ailment)
); 
CREATE TABLE skill_effect ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	effect INTEGER,
	duration INTEGER,   
	multiplier INTEGER, 
	base_damage INTEGER,
	min_damage INTEGER,
	max_damage INTEGER,
	int_limit INTEGER, 
	heal_mul INTEGER, 
	damage_calculation INTEGER, 
	unique(code,effect)
); 
CREATE TABLE enhancement ( 
	id INTEGER PRIMARY KEY NOT NULL,
	code INTEGER, 
	value TEXT,
	unique(code)
); 