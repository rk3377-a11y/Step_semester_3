#!/usr/bin/env bash
set -e

TOPIC="encapsulation"
SESSION="feature/session_7"

echo "==> Creating $SESSION from develop"
git checkout develop
git pull origin develop
git checkout -b "$SESSION"

CLASS_DIR="src/main/java/$TOPIC/class_problems"
ASSN_DIR="src/main/java/$TOPIC/assigment_problems"
mkdir -p "$CLASS_DIR" "$ASSN_DIR"

cat > "$CLASS_DIR/PiggyBank.java" <<'EOF'
package encapsulation.class_problems;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println(pb.getSavings());
        pb.withdraw(30);
        System.out.println(pb.getSavings());
        pb.withdraw(500);
        System.out.println(pb.getSavings());
    }
}
EOF

cat > "$CLASS_DIR/Scorecard.java" <<'EOF'
package encapsulation.class_problems;

public class Scorecard {
    private final boolean[] results;
    private final int totalQuestions;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedCount < totalQuestions) {
            results[recordedCount] = correct;
            recordedCount++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
EOF

cat > "$CLASS_DIR/NameTag.java" <<'EOF'
package encapsulation.class_problems;

public class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
EOF

cat > "$CLASS_DIR/Locker.java" <<'EOF'
package encapsulation.class_problems;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678"));
        System.out.println(l.changeCode("0000", "9999"));
    }
}
EOF

cat > "$CLASS_DIR/AttendanceSheet.java" <<'EOF'
package encapsulation.class_problems;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (!isPresent(name) && count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
    }
}
EOF

cat > "$ASSN_DIR/Character.java" <<'EOF'
package encapsulation.assigment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println(c.getHealth());
        c.heal(50);
        System.out.println(c.getHealth());
        c.takeDamage(150);
        System.out.println(c.getHealth());
    }
}
EOF

cat > "$ASSN_DIR/Playlist.java" <<'EOF'
package encapsulation.assigment_problems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println(p.getSongs()[0]);
    }
}
EOF

cat > "$ASSN_DIR/PasswordChecker.java" <<'EOF'
package encapsulation.assigment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) return "Weak";
        if (len < 10) return "Medium";
        return "Strong";
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength());
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());
    }
}
EOF

cat > "$ASSN_DIR/TrafficLight.java" <<'EOF'
package encapsulation.assigment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            default:
                color = "RED";
        }
        return color;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
EOF

cat > "$ASSN_DIR/Cart.java" <<'EOF'
package encapsulation.assigment_problems;

public class Cart {
    private final String cartId;
    private final double[] prices;
    private int count;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}
EOF

echo "==> Committing and pushing $SESSION"
git add .
git commit -m "Session 7: Encapsulation - class + assignment problems (Category C)"
git push -u origin "$SESSION"

echo "==> Updating main branch README"
git checkout main
git pull origin main

TODAY=$(date +%d-%m-%Y)

NEW_ENTRY="## Date: ${TODAY}
**Today's Work:**
- Completed Session 7 (Encapsulation & Access Control, Category C): 5 practice problems (PiggyBank, Scorecard, NameTag, Locker, AttendanceSheet) and 5 assignment problems (Character, Playlist, PasswordChecker, TrafficLight, Cart)

**Next Session Plan:**
- Move on to next topic per STEP schedule

**Issues Faced:**
- None

---
"

if [ -f README.md ]; then
  printf '%s\n%s' "$NEW_ENTRY" "$(cat README.md)" > README.md
else
  printf '%s\n' "$NEW_ENTRY" > README.md
fi

git add README.md
git commit -m "Update README with Session 7 daily log"
git push origin main

echo "==> Done. Branch $SESSION and main README are both pushed."
