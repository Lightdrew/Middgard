


#Terrible python code (I don't use python) that refactors patterns in the tree palette names. Fixes the namespacing change from midgard to middgard -Lightdrew
TARGET_EXTENSIONS = {".nbt", ".dat", ".snbt"}

def refactor_pattern(path, old_pattern, new_pattern):
    import nbtlib
    from nbtlib import File
    from nbtlib.tag import String

    file = nbtlib.load(path)

    palette = file.get("palette")

    if palette is None:
        return

    for block in palette:
        if not isinstance(block, (nbtlib.Compound, dict)):
            continue

        name = block.get("Name")

        if isinstance(name, (nbtlib.tag.String, str)):
            block["Name"] = String(name.replace(old_pattern, new_pattern))

    file.save()

    return


def process_file(path, old_pattern, new_pattern):
    refactor_pattern(path, old_pattern, new_pattern)
    print(f"{path}:\n\tRefactored '{old_pattern}' to '{new_pattern}'.")

    pass


def walk_directory(root_dir, old_pattern, new_pattern):
    import os

    for root, _, files in os.walk(root_dir):
        for file in files:
            if any(file.endswith(ext) for ext in TARGET_EXTENSIONS):
                full_path = os.path.join(root, file)
                process_file(full_path, old_pattern, new_pattern)
                pass
            pass
        pass
    pass



if __name__ == "__main__":
    import argparse
    try:
        parser = argparse.ArgumentParser(description="NBT palette names refactoring utility")
        parser.add_argument("directory", help="Root folder to scan")
        parser.add_argument("old_pattern", help="Pattern to replace (e.g. 'oldmod:' to target oldmod namespace)")
        parser.add_argument("new_pattern", help="Replacement pattern (e.g. 'newmod:' to replace oldmod namespace with newmod namespace)")

        args = parser.parse_args()

        walk_directory(args.directory, args.old_pattern, args.new_pattern)
    except Exception as e:
        print(f"Script failed execution: {e}")
    pass